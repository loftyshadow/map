package com.nmz.mapauthserver.mapper;

import com.nmz.mapauthserver.entity.SysMenuEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/28-20:22
 */
@Repository
public interface SysMenuMapper extends CrudRepository<SysMenuEntity, Integer>, QuerydslPredicateExecutor<SysMenuEntity> {


    List<SysMenuEntity> findByParentId(Integer parentId);

}
