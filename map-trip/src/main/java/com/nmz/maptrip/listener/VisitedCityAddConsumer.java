package com.nmz.maptrip.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nmz.mapcommon.api.CityService;
import com.nmz.mapcommon.config.DelayedQueueConfig;
import com.nmz.mapcommon.context.UserIdContext;
import com.nmz.mapcommon.entity.CityEntity;
import com.nmz.mapcommon.utils.JacksonUtils;
import com.nmz.maptrip.entity.VisitedCityEntity;
import com.nmz.maptrip.entity.VisitedCityId;
import com.nmz.maptrip.service.VisitedCityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Description: 通过MQ添加旅行过的城市
 * @Author: 聂明智
 * @Date: 2023/12/22-23:40
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class VisitedCityAddConsumer {

    private final VisitedCityService visitedCityService;

    private CityService cityService;

    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    private void receiveDelayQueue(Message message) throws JsonProcessingException {
        String msg = new String(message.getBody());
        Map<String, Object> map = JacksonUtils.json2map(msg);
        VisitedCityEntity visitedCity = new VisitedCityEntity();

        VisitedCityId visitedCityId = new VisitedCityId();
        Long userId = (Long) map.get("userId");
        Long cityId = (Long) map.get("toDoCityId");
        visitedCityId.setUserId(userId);
        visitedCityId.setVisitCityId(cityId);
        CityEntity cityInfo = cityService.getCityInfoById(cityId);

        visitedCity.setVisitedCityId(visitedCityId);
        visitedCity.setVisitCityTime(new Date());
        visitedCity.setVisitedCityName(cityInfo.getCityName());
        visitedCityService.addVisitedCity(visitedCity);
        log.debug("当前时间{}，收到延迟队列的消息{}", new Date(), msg);
    }

}
