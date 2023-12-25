package com.nmz.mapscenicspot.service.impl;

import com.nmz.mapcommon.entity.CityEntity;
import com.nmz.mapscenicspot.mapper.CityRepository;
import com.nmz.mapcommon.api.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nmz.mapscenicspot.exception.CityException.CITY_NOT_EXIST_EXCEPTION;

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
    public CityEntity getCityInfoById(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(() -> CITY_NOT_EXIST_EXCEPTION);
    }

    @Override
    public List<CityEntity> getCityList() {
        return cityRepository.findByParentCityId(0L);
    }

    @Override
    public List<CityEntity> getChildrenCityList(Long parentCityId) {
        return cityRepository.findByParentCityId(parentCityId);
    }
}
