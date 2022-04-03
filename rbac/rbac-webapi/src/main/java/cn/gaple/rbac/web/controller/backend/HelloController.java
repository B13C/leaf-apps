package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.service.TbAdService;
import cn.maple.core.framework.annotation.GXIgnoreLoginIntercept;
import cn.maple.core.framework.controller.GXBaseController;
import cn.maple.core.framework.util.GXResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理员管理
 */
@RestController
@RequestMapping("/hello/backend")
@Slf4j
public class HelloController implements GXBaseController {
    @Resource
    private TbAdService tbAdService;

    @GetMapping("test")
    @GXIgnoreLoginIntercept
    public GXResultUtils<String> test() {
        tbAdService.test();
        return GXResultUtils.ok("Hello Britton");
    }
}
