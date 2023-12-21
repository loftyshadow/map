package com.nmz.mapscenicspot.service.impl;

import com.nmz.mapscenicspot.dto.ScenicSpotTypeDTO;
import com.nmz.mapscenicspot.enums.ScenicSpotParentTypeEnum;
import com.nmz.mapscenicspot.mapper.ScenicSpotTypeRepository;
import com.nmz.mapscenicspot.service.ScenicSpotTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/21-14:43
 */
@SpringBootTest
class ScenicSpotTypeServiceImplTest {

    @Autowired
    ScenicSpotTypeService scenicSpotTypeService;

    @Autowired
    ScenicSpotTypeRepository scenicSpotTypeRepository;

    @Test
    void addLandScenery() {
        // given
        List<ScenicSpotTypeDTO> landSceneryList = new ArrayList<>();
        ScenicSpotParentTypeEnum landScenery = ScenicSpotParentTypeEnum.LAND_SCENERY;
        landSceneryList.add(new ScenicSpotTypeDTO(1, landScenery, "平原"));
        landSceneryList.add(new ScenicSpotTypeDTO(2, landScenery, "戈壁"));
        landSceneryList.add(new ScenicSpotTypeDTO(3, landScenery, "峡谷"));
        landSceneryList.add(new ScenicSpotTypeDTO(4, landScenery, "峰林"));
        landSceneryList.add(new ScenicSpotTypeDTO(5, landScenery, "钙华"));
        landSceneryList.add(new ScenicSpotTypeDTO(6, landScenery, "石柱"));
        landSceneryList.add(new ScenicSpotTypeDTO(7, landScenery, "火山"));
        landSceneryList.add(new ScenicSpotTypeDTO(8, landScenery, "岩石"));
        landSceneryList.add(new ScenicSpotTypeDTO(9, landScenery, "雪山"));
        landSceneryList.add(new ScenicSpotTypeDTO(10, landScenery, "绿洲"));
        landSceneryList.add(new ScenicSpotTypeDTO(11, landScenery, "沙地"));
        landSceneryList.add(new ScenicSpotTypeDTO(12, landScenery, "雅丹"));
        landSceneryList.add(new ScenicSpotTypeDTO(13, landScenery, "山地"));
        landSceneryList.add(new ScenicSpotTypeDTO(14, landScenery, "丘陵"));
        landSceneryList.add(new ScenicSpotTypeDTO(15, landScenery, "高原"));
        landSceneryList.add(new ScenicSpotTypeDTO(16, landScenery, "盆地"));
        landSceneryList.add(new ScenicSpotTypeDTO(17, landScenery, "喀斯特"));
        landSceneryList.add(new ScenicSpotTypeDTO(18, landScenery, "洞穴"));
        landSceneryList.add(new ScenicSpotTypeDTO(19, landScenery, "石林"));
        landSceneryList.add(new ScenicSpotTypeDTO(20, landScenery, "丹霞"));
        landSceneryList.add(new ScenicSpotTypeDTO(21, landScenery, "彩丘"));

        // when
        for (ScenicSpotTypeDTO scenicSpotTypeDTO : landSceneryList) {
            scenicSpotTypeService.addScenicSpotType(scenicSpotTypeDTO);
        }

        // then
        Assertions.assertEquals(landSceneryList.size(), scenicSpotTypeRepository.findByScenicSpotParentType(landScenery).size());
    }


    @Test
    void addHydrologicalLandscape() {
        // given
        List<ScenicSpotTypeDTO> hydrologicalLandscapeList = new ArrayList<>();
        ScenicSpotParentTypeEnum hydrologicalLandscape = ScenicSpotParentTypeEnum.HYDROLOGICAL_LANDSCAPE;
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(22, hydrologicalLandscape, "湿地"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(23, hydrologicalLandscape, "礁石"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(24, hydrologicalLandscape, "冰川"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(25, hydrologicalLandscape, "湖泊"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(26, hydrologicalLandscape, "冲积扇"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(27, hydrologicalLandscape, "三角洲"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(28, hydrologicalLandscape, "岛屿"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(29, hydrologicalLandscape, "半岛"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(30, hydrologicalLandscape, "海岸"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(31, hydrologicalLandscape, "河流"));
        hydrologicalLandscapeList.add(new ScenicSpotTypeDTO(32, hydrologicalLandscape, "瀑布"));

        // when
        for (ScenicSpotTypeDTO scenicSpotTypeDTO : hydrologicalLandscapeList) {
            scenicSpotTypeService.addScenicSpotType(scenicSpotTypeDTO);
        }

        // then
        Assertions.assertEquals(hydrologicalLandscapeList.size(), scenicSpotTypeRepository.findByScenicSpotParentType(hydrologicalLandscape).size());
    }

    @Test
    void addBiologicalLandscape() {
        // given
        List<ScenicSpotTypeDTO> biologicalLandscapeList = new ArrayList<>();
        ScenicSpotParentTypeEnum biologicalLandscape = ScenicSpotParentTypeEnum.BIOLOGICAL_LANDSCAPE;
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(33, biologicalLandscape, "热带雨林"));
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(34, biologicalLandscape, "草原"));
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(35, biologicalLandscape, "牧场"));
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(36, biologicalLandscape, "林场"));
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(37, biologicalLandscape, "林地"));
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(38, biologicalLandscape, "农场"));
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(39, biologicalLandscape, "庄园"));
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(40, biologicalLandscape, "花地"));
        biologicalLandscapeList.add(new ScenicSpotTypeDTO(41, biologicalLandscape, "梯田"));

        // when
        for (ScenicSpotTypeDTO scenicSpotTypeDTO : biologicalLandscapeList) {
            scenicSpotTypeService.addScenicSpotType(scenicSpotTypeDTO);
        }

        // then
        Assertions.assertEquals(biologicalLandscapeList.size(), scenicSpotTypeRepository.findByScenicSpotParentType(biologicalLandscape).size());
    }

    @Test
    void addMeteorologyAndAstronomicalLandscape() {
        // given
        List<ScenicSpotTypeDTO> meteorologyAndAstronomicalLandscapeList = new ArrayList<>();
        ScenicSpotParentTypeEnum meteorologyAndAstronomicalLandscape = ScenicSpotParentTypeEnum.METEOROLOGY_AND_ASTRONOMICAL_LANDSCAPE;
        meteorologyAndAstronomicalLandscapeList.add(new ScenicSpotTypeDTO(42, meteorologyAndAstronomicalLandscape, "观星地"));
        meteorologyAndAstronomicalLandscapeList.add(new ScenicSpotTypeDTO(43, meteorologyAndAstronomicalLandscape, "海市蜃楼"));
        meteorologyAndAstronomicalLandscapeList.add(new ScenicSpotTypeDTO(44, meteorologyAndAstronomicalLandscape, "云雾"));
        meteorologyAndAstronomicalLandscapeList.add(new ScenicSpotTypeDTO(45, meteorologyAndAstronomicalLandscape, "极光"));
        meteorologyAndAstronomicalLandscapeList.add(new ScenicSpotTypeDTO(46, meteorologyAndAstronomicalLandscape, "雾松"));
        meteorologyAndAstronomicalLandscapeList.add(new ScenicSpotTypeDTO(47, meteorologyAndAstronomicalLandscape, "星空天象"));

        // when
        for (ScenicSpotTypeDTO scenicSpotTypeDTO : meteorologyAndAstronomicalLandscapeList) {
            scenicSpotTypeService.addScenicSpotType(scenicSpotTypeDTO);
        }

        // then
        Assertions.assertEquals(meteorologyAndAstronomicalLandscapeList.size(), scenicSpotTypeRepository.findByScenicSpotParentType(meteorologyAndAstronomicalLandscape).size());
    }

    @Test
    void addRuinsAndRelicLandscape() {
        // given
        List<ScenicSpotTypeDTO> ruinsAndRelicLandscapeList = new ArrayList<>();
        ScenicSpotParentTypeEnum ruinsAndRelicLandscape = ScenicSpotParentTypeEnum.RUINS_AND_RELIC_LANDSCAPE;
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(48, ruinsAndRelicLandscape, "寺庙"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(49, ruinsAndRelicLandscape, "古塔"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(50, ruinsAndRelicLandscape, "古村"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(51, ruinsAndRelicLandscape, "古镇"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(52, ruinsAndRelicLandscape, "陵墓"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(53, ruinsAndRelicLandscape, "宫殿"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(54, ruinsAndRelicLandscape, "红色景区"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(55, ruinsAndRelicLandscape, "化石景观"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(56, ruinsAndRelicLandscape, "古典园林"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(57, ruinsAndRelicLandscape, "古道"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(58, ruinsAndRelicLandscape, "古楼"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(59, ruinsAndRelicLandscape, "祠堂"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(60, ruinsAndRelicLandscape, "岩壁画"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(61, ruinsAndRelicLandscape, "遗址"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(62, ruinsAndRelicLandscape, "碑石牌坊"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(63, ruinsAndRelicLandscape, "石窟"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(64, ruinsAndRelicLandscape, "石刻"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(65, ruinsAndRelicLandscape, "民居"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(66, ruinsAndRelicLandscape, "名人故居故里"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(67, ruinsAndRelicLandscape, "民俗村"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(68, ruinsAndRelicLandscape, "纪念园 (馆/碑)"));
        ruinsAndRelicLandscapeList.add(new ScenicSpotTypeDTO(69, ruinsAndRelicLandscape, "古城"));

        // when
        for (ScenicSpotTypeDTO scenicSpotTypeDTO : ruinsAndRelicLandscapeList) {
            scenicSpotTypeService.addScenicSpotType(scenicSpotTypeDTO);
        }

        // then
        Assertions.assertEquals(ruinsAndRelicLandscapeList.size(), scenicSpotTypeRepository.findByScenicSpotParentType(ruinsAndRelicLandscape).size());
    }

    @Test
    void addArchitectureAndUrbanLandscape() {
        // given
        List<ScenicSpotTypeDTO> architectureAndUrbanLandscapeList = new ArrayList<>();
        ScenicSpotParentTypeEnum architectureAndUrbanLandscape = ScenicSpotParentTypeEnum.ARCHITECTURE_AND_URBAN_LANDSCAPE;
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(70, architectureAndUrbanLandscape, "工业基地"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(71, architectureAndUrbanLandscape, "公园"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(72, architectureAndUrbanLandscape, "城市建筑"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(73, architectureAndUrbanLandscape, "现代园林"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(74, architectureAndUrbanLandscape, "铁路"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(75, architectureAndUrbanLandscape, "高速"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(76, architectureAndUrbanLandscape, "国道"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(77, architectureAndUrbanLandscape, "矿山公园"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(78, architectureAndUrbanLandscape, "桥梁"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(79, architectureAndUrbanLandscape, "运河"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(80, architectureAndUrbanLandscape, "水电站"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(81, architectureAndUrbanLandscape, "大坝"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(82, architectureAndUrbanLandscape, "水库"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(83, architectureAndUrbanLandscape, "电视塔"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(84, architectureAndUrbanLandscape, "农业基地"));
        architectureAndUrbanLandscapeList.add(new ScenicSpotTypeDTO(85, architectureAndUrbanLandscape, "公路"));
        // when
        for (ScenicSpotTypeDTO scenicSpotTypeDTO : architectureAndUrbanLandscapeList) {
            scenicSpotTypeService.addScenicSpotType(scenicSpotTypeDTO);
        }

        // then
        Assertions.assertEquals(architectureAndUrbanLandscapeList.size(), scenicSpotTypeRepository.findByScenicSpotParentType(architectureAndUrbanLandscape).size());
    }

    @Test
    void addLandscapeOfCulturalActivities() {
        // given
        List<ScenicSpotTypeDTO> landscapeOfCulturalActivitiesList = new ArrayList<>();
        ScenicSpotParentTypeEnum landscapeOfCulturalActivities = ScenicSpotParentTypeEnum.LANDSCAPE_OF_CULTURAL_ACTIVITIES;
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(86, landscapeOfCulturalActivities, "城区"));
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(87, landscapeOfCulturalActivities, "边城"));
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(88, landscapeOfCulturalActivities, "口岸"));
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(89, landscapeOfCulturalActivities, "博物馆"));
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(90, landscapeOfCulturalActivities, "科技馆"));
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(91, landscapeOfCulturalActivities, "展览馆"));
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(92, landscapeOfCulturalActivities, "影视城"));
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(93, landscapeOfCulturalActivities, "游乐园"));
        landscapeOfCulturalActivitiesList.add(new ScenicSpotTypeDTO(94, landscapeOfCulturalActivities, "温泉"));

        // when
        for (ScenicSpotTypeDTO scenicSpotTypeDTO : landscapeOfCulturalActivitiesList) {
            scenicSpotTypeService.addScenicSpotType(scenicSpotTypeDTO);
        }

        // then
        Assertions.assertEquals(landscapeOfCulturalActivitiesList.size(), scenicSpotTypeRepository.findByScenicSpotParentType(landscapeOfCulturalActivities).size());
    }

    @Test
    void addDirectory() {
        // given
        List<ScenicSpotTypeDTO> directoryLst = new ArrayList<>();
        ScenicSpotParentTypeEnum directory = ScenicSpotParentTypeEnum.DIRECTORY;
        directoryLst.add(new ScenicSpotTypeDTO(95, directory, "世界自然遗产"));
        directoryLst.add(new ScenicSpotTypeDTO(96, directory, "世界文化遗产"));
        directoryLst.add(new ScenicSpotTypeDTO(97, directory, "世界文化与自然双重遗产"));
        directoryLst.add(new ScenicSpotTypeDTO(98, directory, "世界文化景观"));
        directoryLst.add(new ScenicSpotTypeDTO(99, directory, "中国国家森林公园名录"));
        directoryLst.add(new ScenicSpotTypeDTO(100, directory, "中国世界级自然保护区名录"));
        directoryLst.add(new ScenicSpotTypeDTO(101, directory, "中国地质公园名录"));
        directoryLst.add(new ScenicSpotTypeDTO(102, directory, "中国国家级自然保护区名录"));
        directoryLst.add(new ScenicSpotTypeDTO(103, directory, "国家级非物质文化遗产名录"));

        // when
        for (ScenicSpotTypeDTO scenicSpotTypeDTO : directoryLst) {
            scenicSpotTypeService.addScenicSpotType(scenicSpotTypeDTO);
        }

        // then
        Assertions.assertEquals(directoryLst.size(), scenicSpotTypeRepository.findByScenicSpotParentType(directory).size());
    }

}