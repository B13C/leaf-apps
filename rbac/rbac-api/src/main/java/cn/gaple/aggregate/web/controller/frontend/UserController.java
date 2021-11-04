package cn.gaple.aggregate.web.controller.frontend;

import cn.gaple.aggregate.web.dto.protocol.req.UserReqProtocol;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.util.GXResultUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.zookeeper.Testable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @DubboReference
    private Test
    @PostMapping("index")
    public GXResultUtil<String> hello(@GXRequestBody @Validated UserReqProtocol userReqProtocol) {
        System.out.println(userReqProtocol);
        System.out.println(userReqProtocol.getAuthor());
        String s = "";
        return GXResultUtil.ok("Hello World" + s);
    }
}
