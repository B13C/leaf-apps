package cn.gaple.aggregate.web.controller.frontend;

import cn.gaple.aggregate.web.dto.protocol.req.UserReqProtocol;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.util.GXResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("index")
    public GXResultUtils<String> hello(@GXRequestBody @Validated UserReqProtocol userReqProtocol) {
        System.out.println(userReqProtocol);
        System.out.println(userReqProtocol.getAuthor());
        return GXResultUtils.ok("Hello World");
    }
}
