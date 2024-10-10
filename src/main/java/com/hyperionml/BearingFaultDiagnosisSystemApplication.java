package com.hyperionml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BearingFaultDiagnosisSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BearingFaultDiagnosisSystemApplication.class, args);
    }

}
