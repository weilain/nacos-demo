package com.dxp.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author carzy
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAApplication.class, args);
    }
}