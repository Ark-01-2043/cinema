package com.jpn2018.phongchieuservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhongchieuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhongchieuServiceApplication.class, args);
	}

}
