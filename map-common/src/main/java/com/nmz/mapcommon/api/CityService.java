package com.nmz.mapcommon.api;


import com.nmz.mapcommon.entity.CityEntity;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

/**
 * @Description: 城市接口
 * @Author: 聂明智
 * @Date: 2023/12/17-0:15
 */
@DubboService
public interface CityService {

    CityEntity getCityInfoById(Long cityId);

    List<CityEntity> getCityList();

    List<CityEntity> getChildrenCityList(Long parentCityId);

}
