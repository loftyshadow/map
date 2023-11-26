package com.nmz.maptodo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-18:36
 */
public record RecordDetailDTO(String text, Boolean isDelete, Boolean checked) {

}
