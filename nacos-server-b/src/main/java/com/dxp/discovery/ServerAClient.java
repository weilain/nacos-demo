package com.dxp.discovery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "server-a", url = "http://localhost:8011/")
public interface ServerAClient {

    @GetMapping(value = "/server/a/test")
    String test();

}
