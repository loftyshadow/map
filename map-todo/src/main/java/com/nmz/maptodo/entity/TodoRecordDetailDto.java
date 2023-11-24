package com.nmz.maptodo.entity;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link TodoRecordDetail}
 */
@Value
public class TodoRecordDetailDto implements Serializable {
    Boolean detailChecked;
    Boolean detailIsDelete;
    String detailText;
}