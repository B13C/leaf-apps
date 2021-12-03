package cn.gaple.aggregate.web.controller.frontend;

import cn.gaple.aggregate.web.dto.protocol.req.UserReqProtocol;
import cn.gaple.properties.LightTypeProperties;
import cn.gaple.rbac.api.HelloApi;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.util.GXLoggerUtils;
import cn.maple.core.framework.util.GXResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    @DubboReference
    private HelloApi helloApi;

    @Resource
    private LightTypeProperties lightTypeProperties;

    /*public GXResultUtils<Dict> defaultFallback(UserReqProtocol userReqProtocol, Throwable e) {
        System.out.println("Go to default fallback");
        return GXResultUtils.ok(Dict.create());
    }*/

    @PostMapping("index")
    public GXResultUtils<Dict> hello(@GXRequestBody @Validated UserReqProtocol userReqProtocol) {
        GXLoggerUtils.logInfo(log, "用户登录入参", userReqProtocol);
        List<LightTypeProperties.LightTypeValueProperties> types = lightTypeProperties.getTypes();
        helloApi.hello("aaaaaAAA");
        return GXResultUtils.ok(Dict.create().set("call", "Hello World" + helloApi.hello("AAAABBBB")).set("lights", types));
    }
}
