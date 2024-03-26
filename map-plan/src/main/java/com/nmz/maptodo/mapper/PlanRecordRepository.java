package com.nmz.maptodo.mapper;

import com.nmz.maptodo.entity.PlanRecord;
import com.nmz.maptodo.entity.PlanRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanRecordRepository extends JpaRepository<PlanRecord, PlanRecordId> {
    @Query("select p from PlanRecord p where p.id.recordId = ?1")
    Optional<PlanRecord> findByRecordId(Long recordId);
}