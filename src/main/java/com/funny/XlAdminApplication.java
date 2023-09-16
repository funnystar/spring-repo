package com.funny;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.funny.*.mapper")

public class XlAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(XlAdminApplication.class, args);
    }

}
