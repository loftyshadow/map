package com.nmz.maptodo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
                         List<RecordDetailDTO> recordDetail){
}
