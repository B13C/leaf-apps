package cn.gaple.user.controller;

import cn.maple.core.framework.util.GXResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index/frontend1/")
public class IndexController {
    @GetMapping("index")
    public GXResultUtils<String> index() {
        return GXResultUtils.ok("SSO , Hello World");
    }
}
