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
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordDetailDTO {

    private String text;

    private Boolean isDelete;

    private Boolean checked;

}
