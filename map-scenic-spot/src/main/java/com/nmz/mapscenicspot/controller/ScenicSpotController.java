package com.nmz.mapscenicspot.controller;

import com.nmz.mapscenicspot.dto.ScenicSpotDTO;
import com.nmz.mapscenicspot.service.ScenicSpotService;
import com.nmz.mapscenicspot.service.ScenicSpotTypeService;
import com.nmz.mapscenicspot.vo.ScenicSpotVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/19-15:40
 */
@RestController
@Schema(title = "景点Controller", description = "景点相关的接口")
@RequestMapping("/scenic_spot")
@RequiredArgsConstructor
public class ScenicSpotController {

    private final ScenicSpotService scenicSpotService;

    @GetMapping
    public ScenicSpotVO getScenicSpot(ScenicSpotDTO scenicSpotDTO) {
        return scenicSpotService.getScenicSpot(scenicSpotDTO);
    }

    @GetMapping("/hot_list")
    public List<ScenicSpotVO> getScenicSpotList(int count) {
        return scenicSpotService.getScenicSpotHotList(count);
    }

}
