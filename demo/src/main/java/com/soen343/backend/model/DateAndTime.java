package com.soen343.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

import java.util.Calendar;
import java.util.Date;

public class DateAndTime {

    private Date date;
    private Calendar calendar;

    public DateAndTime(@JsonProperty("date") Date date)
    {
        this.date =  date;
    }

    public Date getDate()
    {
        return calendar.getTime();
    }
}
