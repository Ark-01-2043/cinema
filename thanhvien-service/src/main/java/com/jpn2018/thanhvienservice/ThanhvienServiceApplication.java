package com.jpn2018.thanhvienservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ThanhvienServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThanhvienServiceApplication.class, args);
    }

}
