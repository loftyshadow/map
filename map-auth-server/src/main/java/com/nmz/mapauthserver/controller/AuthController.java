package com.nmz.mapauthserver.controller;

import com.nmz.mapauthserver.entity.SysUserEntity;
import com.nmz.mapauthserver.result.Result;
import com.nmz.mapauthserver.service.AuthService;
import com.nmz.mapauthserver.vo.LoginVO;
import com.nmz.mapauthserver.vo.RouteRecordRawVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.nmz.mapauthserver.utils.SecurityUtil.getUserIdBySecurity;


/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/22-15:08
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody SysUserEntity user){
        return authService.login(user);
    }

    @GetMapping("/menu/list")
    public Result<List<RouteRecordRawVO>> getUserMenu(){
        Integer userId = getUserIdBySecurity();
        return authService.getUserMenu(userId);
    }

    @PostMapping("/logout")
    public Result<String> logout(){
        Integer userId = getUserIdBySecurity();
        return authService.logout(userId);
    }

}
