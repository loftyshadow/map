package com.nmz.maptodo.mapper;

import com.nmz.maptodo.entity.PlanRecordDetail;
import com.nmz.maptodo.entity.PlanRecordDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRecordDetailRepository extends JpaRepository<PlanRecordDetail, PlanRecordDetailId> {

    @Query("select t from PlanRecordDetail t where t.id.recordId = ?1 and t.detailIsDelete = false")
    List<PlanRecordDetail> getToDoRecordDetailByRecordId(@NonNull Long recordId);

}