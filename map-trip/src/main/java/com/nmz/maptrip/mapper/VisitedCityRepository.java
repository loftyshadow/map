package com.nmz.maptrip.mapper;

import com.nmz.maptrip.entity.VisitedCity;
import com.nmz.maptrip.entity.VisitedCityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitedCityRepository extends JpaRepository<VisitedCity, VisitedCityId> {
}