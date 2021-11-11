package cn.gaple.rbac.web.controller.frontend;

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

    @GetMapping("test")
    public GXResultUtils<Dict> testNacos() {
        String name = testProperties.getMy();
        return GXResultUtils.ok(Dict.create().set("name", name).set("aa", "枫叶思源"));
    }
}
