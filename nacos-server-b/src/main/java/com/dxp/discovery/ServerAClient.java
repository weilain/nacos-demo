package com.dxp.discovery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-server-a")
public interface ServerAClient {

    @GetMapping(value = "/server/a/test")
    String test();

}
