package com.nmz.mapauthserver.mapper;

import com.nmz.mapauthserver.entity.SysUserEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/26-17:50
 */
@Repository
public interface SysUserMapper extends CrudRepository<SysUserEntity, Integer>, QuerydslPredicateExecutor<SysUserEntity> {

    SysUserEntity findByUserName(String userName);

}
