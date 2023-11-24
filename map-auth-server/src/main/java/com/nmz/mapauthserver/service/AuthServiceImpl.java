package com.nmz.mapauthserver.service;

import com.nmz.mapauthserver.entity.LoginUser;
import com.nmz.mapauthserver.entity.SysMenuEntity;
import com.nmz.mapauthserver.entity.SysUserEntity;
import com.nmz.mapauthserver.mapper.SysMenuMapper;
import com.nmz.mapauthserver.mapper.SysUserRoleMapper;
import com.nmz.mapcommon.result.Result;
import com.nmz.mapauthserver.utils.JwtUtils;
import com.nmz.mapauthserver.vo.LoginVO;
import com.nmz.mapauthserver.vo.RouteRecordRawVO;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.nmz.mapauthserver.entity.QSysMenuEntity.sysMenuEntity;
import static com.nmz.mapauthserver.entity.QSysRoleMenuEntity.sysRoleMenuEntity;
import static com.nmz.mapauthserver.exception.AuthException.CERTIFICATION_FAILED;
import static com.nmz.mapauthserver.exception.BaseException.BAD_PARAMETER;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/10/1-14:51
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ValueOperations<String, Object> valueOperations;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final SysMenuMapper sysMenuMapper;
    private final SysUserRoleMapper sysUserRoleMapper;
    private final JPAQueryFactory queryFactory;
    private static final String REDIS_LOGIN_KEY = "login";

    @Override
    public Result<LoginVO> login(SysUserEntity user) {
        if (Objects.isNull(user)) {
            throw BAD_PARAMETER;
        }
        // AuthenticationManager authenticate进行用户认证
        Authentication authenticate = getAuthentication(user);
        //如果认证通过了，使用userid僧成一个jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        long id = loginUser.getUser().getUserId();
        String token = JwtUtils.createToken((int) id);
        //把完整的用户信息存入redis userid作为key
        valueOperations.set(REDIS_LOGIN_KEY + id, loginUser);
        return Result.success("登陆成功", new LoginVO(token));
    }

    private Authentication getAuthentication(SysUserEntity user) {
        Authentication authenticate;
        try {
            AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
            authenticate = authenticationManager.authenticate(authenticationToken);
        } catch (Exception e) {
            throw CERTIFICATION_FAILED;
        }
        //如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw CERTIFICATION_FAILED;
        }
        return authenticate;
    }

    @Override
    public Result<List<RouteRecordRawVO>> getUserMenu(Integer userId) {
        int roleId = sysUserRoleMapper.findByUserId(userId).getRoleId();
        List<Integer> menuIds = queryFactory.select(sysRoleMenuEntity.menuId).from(sysRoleMenuEntity).where(sysRoleMenuEntity.roleId.eq(roleId)).fetch();
        Predicate p = sysMenuEntity.menuId.in(menuIds).and(sysMenuEntity.parentId.eq(0));
        List<SysMenuEntity> menus = queryFactory
                .select(sysMenuEntity)
                .from(sysMenuEntity)
                .where(p)
                .fetch();
        List<RouteRecordRawVO> finalMenus = new ArrayList<>();
        for (SysMenuEntity menu : menus) {
            finalMenus.add(getChildrenMenu(menu));
        }
        return Result.success(finalMenus);
    }

    /**
     * 递归获取子菜单
     * @param menu 当前菜单
     * @return 返回当前菜单的子菜单
     *         及子菜单递归的所有子菜单
     */
    private RouteRecordRawVO getChildrenMenu(SysMenuEntity menu) {
        int parentId = menu.getMenuId();
        RouteRecordRawVO voMenu = RouteRecordRawVO.toRouteRecordRawVO(menu);
        List<SysMenuEntity> childMenuId = sysMenuMapper.findByParentId(parentId);
        if (childMenuId.isEmpty()) {
            return voMenu;
        }
        List<RouteRecordRawVO> childMenu = new ArrayList<>();
        for (SysMenuEntity menuEntity : childMenuId) {
            RouteRecordRawVO childrenMenu = getChildrenMenu(menuEntity);
            childMenu.add(childrenMenu);
        }
        voMenu.setChildren(childMenu);
        return voMenu;
    }

    @Override
    public Result<String> logout(Integer userId) {
        valueOperations.getAndDelete(REDIS_LOGIN_KEY + userId);
        return Result.success("登出成功");
    }
}
