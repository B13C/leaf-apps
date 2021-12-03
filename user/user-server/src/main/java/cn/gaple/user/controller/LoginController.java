package cn.gaple.user.controller;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.util.GXResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class LoginController {


    @GetMapping("login")
    public GXResultUtils<Dict> login(HttpServletRequest request, HttpServletResponse response) {
        String token = "";
        return GXResultUtils.ok(Dict.create().set("token", token));
    }
}
