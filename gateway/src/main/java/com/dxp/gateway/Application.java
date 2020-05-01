package com.dxp.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author gaohui
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

    @Autowired
    private RouteLocator routeLocator;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("routes")
    public Mono<RouteLocator> getRouteLocator(){
        return Mono.just(routeLocator);
    }

}
