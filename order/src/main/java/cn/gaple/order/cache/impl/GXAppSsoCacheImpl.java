package cn.gaple.order.cache.impl;

import cn.gaple.sso.cache.GXSSOCache;
import cn.gaple.sso.security.token.GXSSOToken;
import org.springframework.stereotype.Component;

@Component
public class GXAppSsoCacheImpl implements GXSSOCache {
    @Override
    public GXSSOToken get(String key, int expires) {
        return null;
    }

    @Override
    public boolean set(String key, GXSSOToken ssoToken, int expires) {
        return false;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }
}
