package com.nmz.maptrip.service.impl;

import com.nmz.maptrip.entity.City;
import com.nmz.maptrip.entity.QCity;
import com.nmz.maptrip.mapper.CityRepository;
import com.nmz.maptrip.service.CityService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/17-0:17
 */
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getCityList() {
        return cityRepository.findByParentCityId(0L);
    }

    @Override
    public List<City> getChildrenCityList(Long parentCityId) {
        return cityRepository.findByParentCityId(parentCityId);
    }
}
