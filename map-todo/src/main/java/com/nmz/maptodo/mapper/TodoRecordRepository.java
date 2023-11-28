package com.nmz.maptodo.mapper;

import com.nmz.maptodo.entity.TodoRecord;
import com.nmz.maptodo.entity.TodoRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRecordRepository extends JpaRepository<TodoRecord, TodoRecordId> {
}