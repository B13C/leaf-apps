package cn.gaple.rbac.web.controller.frontend;

import cn.gaple.rbac.service.MyTestService;
import cn.gaple.rbac.web.properties.TestNacosProperties;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.util.GXResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    private TestNacosProperties testProperties;

    @Resource
    private MyTestService myTestService;

    @GetMapping("test")
    public GXResultUtils<Dict> testNacos() {
        myTestService.test();
        return GXResultUtils.ok(Dict.create().set("name", "AAAA").set("aa", "枫叶思源"));
    }
}
