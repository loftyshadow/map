package com.nmz.maptrip.service.impl;

import com.nmz.maptrip.entity.VisitedCity;
import com.nmz.maptrip.mapper.VisitedCityRepository;
import com.nmz.maptrip.service.VisitedCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/6-23:32
 */
@Service
@RequiredArgsConstructor
public class VisitedCityServiceImpl implements VisitedCityService {

    private final VisitedCityRepository visitedCityRepository;

    @Override
    public void addVisitedCity(VisitedCity visitedCity) {
        visitedCityRepository.save(visitedCity);
    }
}
