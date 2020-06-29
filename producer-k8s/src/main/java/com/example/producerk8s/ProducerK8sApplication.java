package com.example.producerk8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class ProducerK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerK8sApplication.class, args);
    }

}
