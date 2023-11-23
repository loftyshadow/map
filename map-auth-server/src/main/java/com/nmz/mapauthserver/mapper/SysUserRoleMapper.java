package com.nmz.mapauthserver.mapper;

import com.nmz.mapauthserver.entity.SysUserRoleEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/28-20:25
 */
public interface SysUserRoleMapper extends CrudRepository<SysUserRoleEntity, Integer>, QuerydslPredicateExecutor<SysUserRoleEntity> {
    SysUserRoleEntity findByUserId(int userId);
}
