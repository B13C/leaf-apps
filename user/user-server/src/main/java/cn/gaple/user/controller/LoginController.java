package cn.gaple.user.controller;

import cn.gaple.user.plugins.impl.GXLoginSSOPluginImpl;
import cn.hutool.core.lang.Dict;
import com.geoxus.core.framework.util.GXResultUtil;
import com.geoxus.core.framework.util.GXSpringContextUtil;
import com.geoxus.sso.cache.GXSSOCache;
import com.geoxus.sso.config.GXSSOConfig;
import com.geoxus.sso.enums.GXTokenOrigin;
import com.geoxus.sso.properties.GXSSOConfigProperties;
import com.geoxus.sso.security.token.GXSSOToken;
import com.geoxus.sso.util.GXSSOHelperUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@RestController
@RequestMapping("/")
public class LoginController {
    @Resource
    private GXSSOConfigProperties ssoProperties;

    @GetMapping("login")
    public GXResultUtil<Dict> login(HttpServletRequest request, HttpServletResponse response) {
        GXSSOToken ssoToken = GXSSOToken.create();
        GXSSOConfig ssoConfig = new GXSSOConfig();
        ssoConfig.setPluginList(Collections.singletonList(new GXLoginSSOPluginImpl()))
                .setCache(GXSpringContextUtil.getBean(GXSSOCache.class));
        GXSSOHelperUtil.setSsoConfig(ssoProperties.getConfig()).setSsoToken(ssoToken).getSsoToken()
                .setUserId(1)
                .setIssuer("admin")
                .setUserAgent("我的agent")
                .setOrigin(GXTokenOrigin.HTML5)
                .setTenantId(12899)
                .setTime(System.currentTimeMillis());
        String token = ssoToken.getToken();
        GXSSOHelperUtil.setCookie(request, response, ssoToken);
        return GXResultUtil.ok(Dict.create().set("token", token));
    }
}
