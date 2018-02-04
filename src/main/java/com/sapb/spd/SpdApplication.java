package com.sapb.spd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan({ "com.sapb.demo" })
@Import({ RestConfig.class })
public class SpdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpdApplication.class, args);
    }
}
