package com.examlyproject.application.repositry;

import com.examlyproject.application.entiy.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMomdelRepo extends JpaRepository<LogModel,String> {

    List<LogModel> findByDate(String date);
}

