package com.dxp.discovery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenzhuangzhuang
 * @Date 2022/8/29 14:49
 * @Description
 **/
@RestController
public class TestController {
    @GetMapping("/jenkins")
    public String test() {
        return "Hello Jenkins V3----";
    }
}
