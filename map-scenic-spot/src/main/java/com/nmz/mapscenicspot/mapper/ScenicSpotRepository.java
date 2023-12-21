package com.nmz.mapscenicspot.mapper;

import com.nmz.mapscenicspot.entity.ScenicSpotEntity;
import com.nmz.mapscenicspot.entity.ScenicSpotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenicSpotRepository extends JpaRepository<ScenicSpotEntity, ScenicSpotId> {
}