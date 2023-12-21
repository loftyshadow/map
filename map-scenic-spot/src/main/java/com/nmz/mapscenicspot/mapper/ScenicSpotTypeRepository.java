package com.nmz.mapscenicspot.mapper;

import com.nmz.mapscenicspot.entity.ScenicSpotTypeEntity;
import com.nmz.mapscenicspot.enums.ScenicSpotParentTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenicSpotTypeRepository extends JpaRepository<ScenicSpotTypeEntity, Long> {
    List<ScenicSpotTypeEntity> findByScenicSpotParentType(ScenicSpotParentTypeEnum scenicSpotParentType);
}