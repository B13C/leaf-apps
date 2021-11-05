package cn.gaple.rbac.web.service.impl;

import cn.gaple.rbac.web.dto.protocol.req.UserReqProtocol;
import cn.gaple.rbac.web.service.TestService;
import cn.maple.core.framework.annotation.GXValidated;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void test(@GXValidated UserReqProtocol protocol) {
        System.out.println("aaaaa");
    }
}
