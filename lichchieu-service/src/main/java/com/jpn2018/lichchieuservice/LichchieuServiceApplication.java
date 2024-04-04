package com.jpn2018.lichchieuservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LichchieuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LichchieuServiceApplication.class, args);
	}

}
