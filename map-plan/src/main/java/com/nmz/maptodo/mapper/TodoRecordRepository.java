package com.nmz.maptodo.mapper;

import com.nmz.maptodo.entity.PlanRecord;
import com.nmz.maptodo.entity.PlanRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRecordRepository extends JpaRepository<PlanRecord, PlanRecordId> {
}