package com.jpn2018.phimservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhimServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhimServiceApplication.class, args);
    }

}
