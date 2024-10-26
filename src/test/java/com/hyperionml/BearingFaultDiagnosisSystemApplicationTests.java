package com.hyperionml;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyperionml.controller.BearingController;
import com.hyperionml.mapper.BearingMapper;
import com.hyperionml.pojo.Bearing;
import com.hyperionml.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class BearingFaultDiagnosisSystemApplicationTests {

    @Autowired
    BearingMapper bearingMapper;

    @Autowired
    BearingController bearingController;

    @Test
    void contextLoads() {
        System.out.println(LocalDate.now());
    }

    void test1() {
        PageHelper.startPage(1, 1);
        List<Bearing> bearings = bearingMapper.selectAllBearing();
        Page<Bearing> re = (Page<Bearing>) bearings;
        System.out.println(re.getResult());
    }

    void test2() {
        bearingController.addNewBearingHisSta(1);
    }
}
