package com.hyperionml.service;

import com.hyperionml.pojo.Result;

import java.time.LocalDate;

public interface BearingService {

    Result getAllBearing();

    Result getBearingPage(Integer page, Integer size);

    Result getBearingHistoryStatus(int sid, LocalDate date);

    Result addNewHistoryStatus(int sid);

    Result updateHistoryStatusBy1(int sid, String msg);
}
