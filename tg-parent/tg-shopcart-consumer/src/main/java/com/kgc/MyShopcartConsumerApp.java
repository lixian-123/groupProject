package com.kgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MyShopcartConsumerApp {

    public static void main(String[] args) {
        //mnb
        SpringApplication.run(MyShopcartConsumerApp.class, args);
    }

}
