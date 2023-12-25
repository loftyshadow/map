package com.nmz.mapscenicspot.mapper;

import com.nmz.mapcommon.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long>, QuerydslPredicateExecutor<CityEntity> {
    List<CityEntity> findByParentCityId(Long parentCityId);


}