package com.nmz.mapscenicspot.mapper;

import com.nmz.mapscenicspot.entity.ScenicSpotEntity;
import com.nmz.mapscenicspot.entity.ScenicSpotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenicSpotRepository extends JpaRepository<ScenicSpotEntity, ScenicSpotId> {
    ScenicSpotEntity findByScenicSpotName(String scenicSpotName);
}