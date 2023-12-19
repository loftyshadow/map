package com.nmz.maptrip.mapper;

import com.nmz.maptrip.entity.VisitedCityEntity;
import com.nmz.maptrip.entity.VisitedCityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitedCityRepository extends JpaRepository<VisitedCityEntity, VisitedCityId> {

    @Query("select v from VisitedCityEntity v where v.visitedCityId.userId = ?1")
    List<VisitedCityEntity> findVisitedCityByUserId(Long userId);

}