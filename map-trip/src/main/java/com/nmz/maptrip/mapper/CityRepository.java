package com.nmz.maptrip.mapper;

import com.nmz.maptrip.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, QuerydslPredicateExecutor<City> {
    List<City> findByParentCityId(Long parentCityId);


}