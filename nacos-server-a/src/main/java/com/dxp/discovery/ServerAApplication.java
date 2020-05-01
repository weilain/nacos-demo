package com.dxp.discovery;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author carzy
 */
@SpringBootApplication
@NacosPropertySources({
        @NacosPropertySource(dataId = "server-a.properties", groupId = "demo", name = "carzy"),
})
public class ServerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAApplication.class, args);
    }
}