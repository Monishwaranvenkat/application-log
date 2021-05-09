package com.examlyproject.application.service;

import com.examlyproject.application.entiy.LogModel;
import com.examlyproject.application.repositry.LogMomdelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SuppressWarnings("serial")
@Service
public class LogService {

    @Autowired
    private LogMomdelRepo logMomdelRepo;
    @Transactional
    public void createCheckIn(String name)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String[] s = dtf.format(now).split(" ");
        LogModel logModel = new LogModel();
        logModel.setLogType("IN");
        logModel.setDate(s[0]);
        logModel.setTime(s[1]);
        logModel.setName(name+s[1]);
        logMomdelRepo.save(logModel);
    }

    public void createCheckOut(String name)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String[] s = dtf.format(now).split(" ");
        LogModel logModel = new LogModel();
        logModel.setLogType("OUT");
        logModel.setDate(s[0]);
        logModel.setTime(s[1]);
        logModel.setName(name+s[1]);
        logMomdelRepo.save(logModel);
    }


    public List<LogModel> getAllLog()
    {
        return logMomdelRepo.findAll();
    }

    public List<LogModel> getLogByDate(String date)
    {
        return logMomdelRepo.findByDate(date);
    }
}
