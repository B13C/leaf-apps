package cn.gaple.user.service.api;

import cn.gaple.user.TestApi;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class TestApiImpl implements TestApi {
    @Override
    public String helloApi() {
        return "枫叶思源的测试API";
    }
}
