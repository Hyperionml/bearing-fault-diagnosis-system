package com.hyperionml.controller;

import com.hyperionml.pojo.ReqBody;
import com.hyperionml.pojo.Result;
import com.hyperionml.service.BearingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Tag(name = "轴承故障诊断系统后端接口api文档")
@RestController
@RequestMapping("/gdupt")
public class BearingController {

    @Autowired
    private BearingService bearingService;

    @Operation(summary = "获取全部轴承数据")
    @GetMapping("/bearing/list")
    public Result getAllBearings(){
        return bearingService.getAllBearing();
    }

    @Operation(summary = "分页查询获取轴承数据")
    @GetMapping("/bearing/page")
    public Result getBearingPage(@Parameter(description = "页码") @RequestParam Integer page,
                                 @Parameter(description = "单页显示数据条数") @RequestParam Integer pageSize){
       return bearingService.getBearingPage(page, pageSize);
    }

    @Operation(summary = "根据sid和日期获取轴承历史数据")
    @GetMapping("/history/get")
    public Result getBearingHisStaBySidAndDate(@Parameter(description = "轴承id") @RequestParam Integer sid,
                                               @Parameter(description = "日期", example = "2024-10-01") @RequestParam LocalDate date){
        return bearingService.getBearingHistoryStatus(sid, date);
    }

    @Operation(summary = "新增当天轴承历史数据(请在请求体中携带sid)")
    @PutMapping("/history/add")
    public Result addNewBearingHisSta(@RequestBody Integer sid){
        return bearingService.addNewHistoryStatus(sid);
    }

    @Operation(summary = "更新当天轴承历史数据(只用于添加新的故障信息，非故障请勿调用)")
    @PostMapping("/history/updateBy1")
    public Result updateBearingHisStaBy1(@RequestBody ReqBody reqBody){
        return bearingService.updateHistoryStatusBy1(reqBody.getSid(), reqBody.getErrMsg());
    }
}
