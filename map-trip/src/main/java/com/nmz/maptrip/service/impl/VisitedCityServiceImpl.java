package com.nmz.maptrip.service.impl;

import com.nmz.maptrip.entity.VisitedCityEntity;
import com.nmz.maptrip.mapper.VisitedCityRepository;
import com.nmz.maptrip.service.VisitedCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void addVisitedCity(VisitedCityEntity visitedCity) {
        visitedCityRepository.save(visitedCity);
    }

    @Override
    public List<VisitedCityEntity> getVisitedCityList(Long userId) {
        return visitedCityRepository.findVisitedCityByUserId(userId);
    }
}
