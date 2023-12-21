package com.nmz.mapscenicspot.mapper;

import com.nmz.mapscenicspot.dto.ScenicSpotTypeDTO;
import com.nmz.mapscenicspot.entity.ScenicSpotTypeEntity;
import com.nmz.mapscenicspot.enums.ScenicSpotParentTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/12/21-14:24
 */
@SpringBootTest
class ScenicSpotTypeMapperTest {

    @Autowired
    ScenicSpotTypeMapper underTest;

    @Test
    void testToScenicSpotTypeEntity() {
        // given
        ScenicSpotTypeDTO given = new ScenicSpotTypeDTO(1, ScenicSpotParentTypeEnum.BIOLOGICAL_LANDSCAPE, "热带雨林");

        // when
        ScenicSpotTypeEntity except = underTest.toScenicSpotTypeEntity(given);

        // then
        Assertions.assertAll(
                "转换成功",
                () -> Assertions.assertEquals(given.scenicSpotTypeId(), except.getScenicSpotTypeId()),
                () -> Assertions.assertEquals(given.scenicSpotTypeName(), except.getScenicSpotTypeName()),
                () -> Assertions.assertEquals(given.scenicSpotParentType(), except.getScenicSpotParentType())
        );
    }

}