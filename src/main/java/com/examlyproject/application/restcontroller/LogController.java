package com.examlyproject.application.restcontroller;

import com.examlyproject.application.entiy.LogModel;
import com.examlyproject.application.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@SuppressWarnings("serial")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/checkIn")
    @ResponseStatus(value = HttpStatus.OK)
    public HttpStatus checkIn(@RequestParam("name")String name)
    {


        logService.createCheckIn(name);

         return HttpStatus.OK;

    }

    @GetMapping("/checkOut")
    @ResponseStatus(value = HttpStatus.OK)
    public HttpStatus checkOut(@RequestParam("name")String name)
    {
        logService.createCheckOut(name);
        return HttpStatus.OK;
    }

    @GetMapping("/getAllLog")
    public List<LogModel> getAllLog()
    {
        return logService.getAllLog();
    }

    @GetMapping("/getLog")
    public List<LogModel> getLogByDate(@RequestParam("date") String date)
    {
        return  logService.getLogByDate(date);
    }
}
