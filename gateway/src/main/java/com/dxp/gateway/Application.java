package com.dxp.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
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
    public Mono<RouteLocator> getRouteLocator() {
        return Mono.just(routeLocator);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // 配制一个路由,把 http://网关地址:网关端口/demo/ 下的请求路由到 demo-service 微服务中
                .route(p -> p
                        .path("/sever-a/**") //url匹配
                        .uri("lb://nacos-server-a"))  // 将请求路由到指定目标, lb开头是注册中心中的服务, http/https 开头你懂的
                .build();
    }

}
