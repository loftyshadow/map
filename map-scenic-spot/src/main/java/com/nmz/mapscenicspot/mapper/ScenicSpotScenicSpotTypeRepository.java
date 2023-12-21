package com.nmz.mapscenicspot.mapper;

import com.nmz.mapscenicspot.entity.ScenicSpotScenicSpotTypeEntity;
import com.nmz.mapscenicspot.entity.ScenicSpotScenicSpotTypeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenicSpotScenicSpotTypeRepository extends JpaRepository<ScenicSpotScenicSpotTypeEntity, ScenicSpotScenicSpotTypeId> {
}