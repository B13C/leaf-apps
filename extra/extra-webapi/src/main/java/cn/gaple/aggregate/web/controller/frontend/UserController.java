package cn.gaple.aggregate.web.controller.frontend;

import cn.gaple.aggregate.web.dto.protocol.req.UserReqProtocol;
import com.geoxus.core.framework.annotation.GXRequestBody;
import com.geoxus.core.framework.util.GXResultUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("index")
    public GXResultUtil<String> hello(@GXRequestBody @Validated UserReqProtocol userReqProtocol) {
        System.out.println(userReqProtocol);
        System.out.println(userReqProtocol.getAuthor());
        return GXResultUtil.ok("Hello World");
    }
}
