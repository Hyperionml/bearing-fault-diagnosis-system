package com.hyperionml.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HisStaPo {
    private int hid;
    private int sid;
    private String sname;
    private int errCount;
    private String errMsg;
    private LocalDate date;
}
