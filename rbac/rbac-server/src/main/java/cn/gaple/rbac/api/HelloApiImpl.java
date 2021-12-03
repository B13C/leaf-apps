package cn.gaple.rbac.api;

import cn.gaple.user.TestApi;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.util.GXLoggerUtils;
import cn.maple.core.framework.util.GXTraceIdContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
@Slf4j
public class HelloApiImpl implements HelloApi {
    @DubboReference
    private TestApi testApi;

    @Override
    public String hello(String str) {
        GXLoggerUtils.logInfo(log, "AAA", Dict.create());
        String traceId = GXTraceIdContextUtils.getTraceId();
        String s = testApi.helloApi();
        return "我的测试" + str + " : " + traceId + ":" + s;
    }
}
