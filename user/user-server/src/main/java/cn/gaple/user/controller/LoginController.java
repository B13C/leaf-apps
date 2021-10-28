package cn.gaple.user.controller;

import cn.hutool.core.lang.Dict;
import com.geoxus.core.framework.util.GXResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class LoginController {


    @GetMapping("login")
    public GXResultUtil<Dict> login(HttpServletRequest request, HttpServletResponse response) {
        String token = "";
        return GXResultUtil.ok(Dict.create().set("token", token));
    }
}
