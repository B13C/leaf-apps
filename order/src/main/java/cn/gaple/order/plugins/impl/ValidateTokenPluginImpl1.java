package cn.gaple.order.plugins.impl;

import cn.gaple.sso.plugins.GXSSOPlugin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@Component*/
public class ValidateTokenPluginImpl1 implements GXSSOPlugin {
    @Override
    public boolean login(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }

    @Override
    public boolean logout(HttpServletRequest request, HttpServletResponse response) {
        return false;
    }
}
