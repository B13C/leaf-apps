package cn.gaple.aggregate.web.controller.frontend;

import cn.gaple.aggregate.web.dto.protocol.req.UserReqProtocol;
import cn.gaple.user.TestApi;
import com.geoxus.core.framework.annotation.GXRequestBody;
import com.geoxus.core.framework.util.GXResultUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @DubboReference
    private TestApi testApi;

    @PostMapping("index")
    public GXResultUtil<String> hello(@GXRequestBody @Validated UserReqProtocol userReqProtocol) {
        System.out.println(userReqProtocol);
        System.out.println(userReqProtocol.getAuthor());
        String s = testApi.helloApi();
        return GXResultUtil.ok("Hello World" + s);
    }
}
