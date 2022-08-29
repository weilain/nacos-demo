package com.dxp.discovery;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author carzy
 */
@RestController
public class TestController {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${spring.cloud.nacos.config.group}")
    private String groupName;
    @Value("${server.port}")
    private int port;

    @Autowired
    private ServerAClient serverAClient;

    @GetMapping("/jenkins")
    public String test() {
        return "Hello Jenkins V5----";
    }

    @GetMapping(value = "/test")
    public String jenkins() {
        return "this is server b: " + port;
    }

    @GetMapping(value = "/feign")
    public String feignA(){
        return serverAClient.test();
    }
}

