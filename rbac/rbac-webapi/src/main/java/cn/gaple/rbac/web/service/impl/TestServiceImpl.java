package cn.gaple.rbac.web.service.impl;

import cn.gaple.rbac.web.dto.protocol.req.UserReqProtocol;
import cn.gaple.rbac.web.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void test(UserReqProtocol protocol) {
        System.out.println("aaaaa");
    }
}
