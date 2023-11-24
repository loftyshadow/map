package com.nmz.maptodo.mapper;

import com.nmz.maptodo.entity.TodoRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRecordRepository extends JpaRepository<TodoRecord, Integer> {
}