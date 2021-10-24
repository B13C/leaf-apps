package cn.gaple.order.service.impl;

import cn.gaple.sso.security.token.GXSSOToken;
import cn.gaple.sso.service.GXConfigurableAbstractSSOService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AppConfigurableAbstractSSOServiceImpl extends GXConfigurableAbstractSSOService {
    @Override
    protected GXSSOToken getSSOToken(HttpServletRequest request, String cookieName) {
        System.out.println("MMMKKKLLL");
        return super.getSSOToken(request, cookieName);
    }
}
