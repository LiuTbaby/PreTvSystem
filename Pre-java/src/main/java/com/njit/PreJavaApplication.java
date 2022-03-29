package com.njit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.njit.mapper")
public class PreJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PreJavaApplication.class, args);
    }

}
