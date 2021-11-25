package cn.gaple.aggregate.web.controller.frontend;

import cn.gaple.aggregate.web.dto.protocol.req.UserReqProtocol;
import cn.gaple.properties.LightTypeProperties;
import cn.gaple.rbac.api.HelloApi;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.util.GXResultUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @DubboReference
    private HelloApi helloApi;

    @Resource
    private LightTypeProperties lightTypeProperties;

    @PostMapping("index")
    public GXResultUtils<Dict> hello(@GXRequestBody @Validated UserReqProtocol userReqProtocol) {
        System.out.println(userReqProtocol);
        System.out.println(userReqProtocol.getAuthor());
        String s = "";
        List<LightTypeProperties.LightTypeValueProperties> types = lightTypeProperties.getTypes();

        return GXResultUtils.ok(Dict.create().set("call", "Hello World" + helloApi.hello("AAAABBBB")).set("lights", types));
    }
}
