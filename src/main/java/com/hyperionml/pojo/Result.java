package com.hyperionml.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object reMsg;

    public static Result success(String msg){
        return new Result(1, msg, null);
    }

    public static Result success(String msg, Object re){
        return new Result(1, msg, re);
    }

    public static Result err(String msg) {
        return new Result(2, msg, null);
    }
}

