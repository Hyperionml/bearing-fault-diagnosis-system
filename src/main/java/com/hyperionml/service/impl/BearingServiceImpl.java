package com.hyperionml.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyperionml.mapper.BearingMapper;
import com.hyperionml.pojo.Bearing;
import com.hyperionml.pojo.HistoryStatus;
import com.hyperionml.pojo.Result;
import com.hyperionml.service.BearingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BearingServiceImpl implements BearingService {

    @Autowired
    BearingMapper bearingMapper;

    @Override
    public Result getAllBearing() {
        return Result.success("成功获取全部轴承信息", bearingMapper.selectAllBearing());
    }

    @Override
    public Result getBearingPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Bearing> bearings = bearingMapper.selectAllBearing();
        Page<Bearing> re = (Page<Bearing>) bearings;
        return Result.success("成功获取分页数据", re.getResult());
    }

    @Override
    public Result getBearingHistoryStatus(int sid, LocalDate date) {
        HistoryStatus status = bearingMapper.selectHisStaBySidAndDatetime(sid, date);
        return Result.success("成功获取历史数据", status);
    }

    @Override
    public Result addNewHistoryStatus(int sid) {
        HistoryStatus status = new HistoryStatus();
        status.setSid(sid);
        status.setErrCount(0);
        status.setErrMsg(null);
        status.setDate(LocalDate.now());
        int code = bearingMapper.insertHisSta(status);
        if(code != 0){
            return Result.success("成功更新历史数据");
        }
        else {
            return Result.err("未知原因更新失败");
        }
    }

    @Override
    public Result updateHistoryStatusBy1(int sid, String msg){
        HistoryStatus status = bearingMapper.selectHisStaBySidAndDatetime(sid, LocalDate.now());
        status.setErrCount(status.getErrCount() + 1);
        status.setErrMsg(status.getErrMsg() + ", " + msg);
        int code = bearingMapper.updateHisSta(status);
        if(code != 0){
            return Result.success("成功更新历史数据");
        }
        else {
            return Result.err("未知原因更新失败");
        }
    }
}
