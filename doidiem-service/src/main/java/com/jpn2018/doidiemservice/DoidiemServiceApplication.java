package com.jpn2018.doidiemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DoidiemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoidiemServiceApplication.class, args);
    }

}
