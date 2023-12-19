package com.nmz.mapscenicspot.service;

import com.nmz.mapscenicspot.entity.CityEntity;

import java.util.List;

/**
 * @Description: 城市接口
 * @Author: 聂明智
 * @Date: 2023/12/17-0:15
 */
public interface CityService {

    List<CityEntity> getCityList();

    List<CityEntity> getChildrenCityList(Long parentCityId);

}
