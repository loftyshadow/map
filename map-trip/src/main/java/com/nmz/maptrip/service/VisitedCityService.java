package com.nmz.maptrip.service;

import com.nmz.maptrip.entity.VisitedCity;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/6-23:25
 */
public interface VisitedCityService {

    void addVisitedCity(VisitedCity visitedCity);

    List<VisitedCity> getVisitedCityList(Long userId);

}
