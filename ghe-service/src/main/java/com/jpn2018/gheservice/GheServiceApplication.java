package com.jpn2018.gheservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GheServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GheServiceApplication.class, args);
    }

}
