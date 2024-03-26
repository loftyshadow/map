package com.nmz.maptodo.dto;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-18:25
 */
public record RecordDTO (Long userId,
                         Long id,
                         String title,
                         Boolean isDelete,
                         Boolean locked,
                         Long toDoCityId,
                         Integer planDelay,
                         List<RecordDetailDTO> recordDetail){
}
