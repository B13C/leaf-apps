package cn.gaple.aggregate.web.controller.frontend;

import cn.gaple.aggregate.web.dto.protocol.req.UserReqProtocol;
import cn.gaple.rbac.api.HelloApi;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.util.GXResultUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @DubboReference
    private HelloApi helloApi;

    @PostMapping("index")
    public GXResultUtils<String> hello(@GXRequestBody @Validated UserReqProtocol userReqProtocol) {
        System.out.println(userReqProtocol);
        System.out.println(userReqProtocol.getAuthor());
        String s = "";
        return GXResultUtils.ok("Hello World" + helloApi.hello("AAAABBBB"));
    }
}
