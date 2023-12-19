package com.nmz.mapscenicspot.service.impl;

import com.nmz.mapscenicspot.entity.CityEntity;
import com.nmz.mapscenicspot.mapper.CityRepository;
import com.nmz.mapscenicspot.service.CityService;
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
    public List<CityEntity> getCityList() {
        return cityRepository.findByParentCityId(0L);
    }

    @Override
    public List<CityEntity> getChildrenCityList(Long parentCityId) {
        return cityRepository.findByParentCityId(parentCityId);
    }
}
