package cn.gaple.rbac.api;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloApiImpl implements HelloApi {
    @Override
    public String hello(String str) {
        return "我的测试" + str;
    }
}
