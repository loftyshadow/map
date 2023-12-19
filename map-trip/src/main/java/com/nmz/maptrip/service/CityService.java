package com.nmz.maptrip.service;

import com.nmz.maptrip.entity.City;

import java.util.List;

/**
 * @Description: 城市接口
 * @Author: 聂明智
 * @Date: 2023/12/17-0:15
 */
public interface CityService {

    List<City> getCityList();

    List<City> getChildrenCityList(Long parentCityId);

}
