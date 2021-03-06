package com.kgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.kgc.mapper")
public class GoodsProviderAPP {
    public static void main(String[] args) {
        SpringApplication.run(GoodsProviderAPP.class,args);
    }
}
