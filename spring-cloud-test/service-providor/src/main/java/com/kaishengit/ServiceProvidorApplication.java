package com.kaishengit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProvidorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvidorApplication.class, args);
    }
}
