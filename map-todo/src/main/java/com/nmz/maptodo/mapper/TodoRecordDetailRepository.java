package com.nmz.maptodo.mapper;

import com.nmz.maptodo.entity.TodoRecordDetail;
import com.nmz.maptodo.entity.TodoRecordDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRecordDetailRepository extends JpaRepository<TodoRecordDetail, TodoRecordDetailId> {

    @Query("select t from TodoRecordDetail t where t.id.recordId = ?1 and t.detailIsDelete = false")
    List<TodoRecordDetail> findByRecordId(@NonNull Long recordId);

}