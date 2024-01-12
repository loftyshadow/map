package com.nmz.mapreview.cdc;

import com.alibaba.fastjson2.JSONObject;
import com.nmz.mapcommon.utils.SpringContextUtils;
import com.nmz.mapreview.entity.ReviewEntity;
import com.nmz.mapreview.mapper.ESReviewRepository;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DataChangeSink implements SinkFunction<DataChangeInfo> {

    private static final Logger log = LoggerFactory.getLogger(DataChangeSink.class);

    @Override
    public void invoke(DataChangeInfo dataChangeInfo, Context context) {
        // 变更类型： 0 初始化 1新增 2修改 3删除 4导致源中的现有表被截断的操作
        Integer operatorType = dataChangeInfo.getOperatorType();
        // 数据处理,不能在方法外注入需要的bean，会报错必须实例化才可以，用SpringContextUtils 获取需要的 bean，然后就可以使用封装的方法进行增删改操作了
        ESReviewRepository esReviewRepository = SpringContextUtils.getBean(ESReviewRepository.class);;
        String data = dataChangeInfo.getData();
        log.debug("########data={}", data);
        ReviewEntity review = JSONObject.parseObject(data, ReviewEntity.class);
        switch (operatorType) {
            case 1,2 -> esReviewRepository.save(review);
            case 3,4 -> esReviewRepository.delete(review);
            default -> log.info("操作类型不处理{}", operatorType);
        }
    }

}