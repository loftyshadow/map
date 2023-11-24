package com.nmz.maptodo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/11/24-18:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {

    private Long id;

    private String title;

    private Boolean isDelete;

    private Boolean locked;

    private List<RecordDetailDTO> recordDetail;
}
