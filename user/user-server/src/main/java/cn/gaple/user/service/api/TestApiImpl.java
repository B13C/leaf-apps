package cn.gaple.user.service.api;

import cn.gaple.user.TestApi;
import cn.maple.core.framework.util.GXLoggerUtils;
import cn.maple.core.framework.util.GXTraceIdContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
@Slf4j
public class TestApiImpl implements TestApi {
    @Override
    public String helloApi() {
        GXLoggerUtils.logInfo(log, "BBBBB");
        return "USER枫叶思源的测试API" + " : " + GXTraceIdContextUtils.getTraceId();
    }

    @Override
    public String testApi() {
        return null;
    }
}
