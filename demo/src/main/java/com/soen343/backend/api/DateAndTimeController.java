package com.soen343.backend.api;

import com.soen343.backend.model.User;
import com.soen343.backend.service.DateAndTimeService;
import com.soen343.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public class DateAndTimeController {

    private final DateAndTimeService dateAndTimeService;

    @Autowired
    public DateAndTimeController(DateAndTimeService dateAndTimeService)
    {
        this.dateAndTimeService = dateAndTimeService;
    }

    @GetMapping
    public void getDate()
    {

    }

    @GetMapping
    public void getTime()
    {
    }

    @PutMapping
    public void updateTime()
    {
    }

    @PutMapping
    public void updateDate()
    {

    }
}


