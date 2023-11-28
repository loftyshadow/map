package com.nmz.mapauthserver.service;

import com.nmz.mapauthserver.entity.SysUserEntity;
import com.nmz.mapcommon.result.Result;
import com.nmz.mapauthserver.vo.LoginVO;
import com.nmz.mapauthserver.vo.RouteRecordRawVO;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/27-16:40
 */
public interface AuthService {

    Result<LoginVO> login(SysUserEntity user);

    Result<List<RouteRecordRawVO>> getUserMenu(Long userId);

    Result<String> logout(Long userId);
}
