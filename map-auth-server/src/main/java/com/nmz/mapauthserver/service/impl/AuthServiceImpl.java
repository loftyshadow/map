package com.nmz.mapauthserver.service.impl;

import com.nmz.mapauthserver.entity.LoginUser;
import com.nmz.mapauthserver.entity.SysMenuEntity;
import com.nmz.mapauthserver.entity.SysUserEntity;
import com.nmz.mapauthserver.mapper.SysMenuRepository;
import com.nmz.mapauthserver.mapper.SysUserRoleRepository;
import com.nmz.mapauthserver.service.AuthService;
import com.nmz.mapcommon.result.Result;
import com.nmz.mapauthserver.vo.LoginVO;
import com.nmz.mapauthserver.vo.RouteRecordRawVO;
import com.nmz.mapcommon.utils.JacksonUtils;
import com.nmz.mapcommon.utils.JwtUtils;
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

import static com.nmz.mapauthserver.constant.RedisConstantKey.REDIS_LOGIN_KEY;
import static com.nmz.mapauthserver.constant.RedisConstantKey.REDIS_USER_MENU_KEY;
import static com.nmz.mapauthserver.entity.QSysMenuEntity.sysMenuEntity;
import static com.nmz.mapauthserver.entity.QSysRoleMenuEntity.sysRoleMenuEntity;
import static com.nmz.mapauthserver.exception.AuthException.CERTIFICATION_FAILED;
import static com.nmz.mapcommon.exception.BaseException.BAD_PARAMETER;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/10/1-14:51
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ValueOperations<String, String> valueOperations;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final SysMenuRepository sysMenuMapper;
    private final SysUserRoleRepository sysUserRoleMapper;
    private final JPAQueryFactory queryFactory;

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
        valueOperations.set(REDIS_LOGIN_KEY + id, JacksonUtils.obj2json(loginUser));
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
    public Result<List<RouteRecordRawVO>> getUserMenu(Long userId) {
        if (valueOperations.get(REDIS_USER_MENU_KEY + userId) != null) {
            return Result.success((JacksonUtils.json2list(valueOperations.get(REDIS_USER_MENU_KEY + userId), RouteRecordRawVO.class)));
        }
        long roleId = sysUserRoleMapper.findByUserId(userId).getRoleId();
        List<Long> menuIds = queryFactory.select(sysRoleMenuEntity.menuId).from(sysRoleMenuEntity).where(sysRoleMenuEntity.roleId.eq(roleId)).fetch();
        Predicate p = sysMenuEntity.menuId.in(menuIds).and(sysMenuEntity.parentId.eq(0L));
        List<SysMenuEntity> menus = queryFactory
                .select(sysMenuEntity)
                .from(sysMenuEntity)
                .where(p)
                .fetch();
        List<RouteRecordRawVO> finalMenus = new ArrayList<>();
        for (SysMenuEntity menu : menus) {
            finalMenus.add(getChildrenMenu(menu));
        }
        valueOperations.set(REDIS_USER_MENU_KEY + userId, JacksonUtils.obj2json(finalMenus));
        return Result.success(finalMenus);
    }

    /**
     * 递归获取子菜单
     * @param menu 当前菜单
     * @return 返回当前菜单的子菜单
     *         及子菜单递归的所有子菜单
     */
    private RouteRecordRawVO getChildrenMenu(SysMenuEntity menu) {
        long parentId = menu.getMenuId();
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
    public Result<String> logout(Long userId) {
        valueOperations.getAndDelete(REDIS_LOGIN_KEY + userId);
        return Result.success("登出成功");
    }
}
