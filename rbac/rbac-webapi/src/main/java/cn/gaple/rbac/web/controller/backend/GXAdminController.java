package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.dto.req.GXAdminLoginReqDto;
import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.service.GXAdminService;
import cn.gaple.rbac.web.dto.protocol.req.GXAdminLoginReqProtocol;
import cn.gaple.rbac.web.dto.protocol.req.GXAdminReqProtocol;
import cn.gaple.rbac.web.mapstruct.req.GXAdminLoginReqMapStruct;
import cn.gaple.rbac.web.mapstruct.req.GXAdminWebReqMapStruct;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.controller.GXBaseController;
import cn.maple.core.framework.util.GXResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理员管理
 */
@RestController
@RequestMapping("/admin/backend")
public class GXAdminController implements GXBaseController {
    @Resource
    private GXAdminLoginReqMapStruct adminLoginReqMapStruct;

    @Resource
    private GXAdminWebReqMapStruct adminWebReqMapStruct;

    @Resource
    private GXAdminService adminService;

    /**
     * 管理员登录
     *
     * @param reqProtocol 登录信息
     * @return GXResultUtils
     */
    @PostMapping("login")
    public GXResultUtils<Dict> login(@GXRequestBody @Validated GXAdminLoginReqProtocol reqProtocol) {
        GXAdminLoginReqDto loginReqDto = adminLoginReqMapStruct.sourceToTarget(reqProtocol);
        final String token = adminService.login(loginReqDto);
        return GXResultUtils.ok(Dict.create().set("token", token).set("username", reqProtocol.getUsername()));
    }

    @PostMapping("/save-or-update")
    public GXResultUtils<Dict> saveOrUpdate(@GXRequestBody @Validated GXAdminReqProtocol reqProtocol) {
        GXAdminReqDto adminReqDto = adminWebReqMapStruct.sourceToTarget(reqProtocol);
        Integer adminId = adminService.saveOrUpdate(adminReqDto);
        return GXResultUtils.ok(Dict.create().set("adminId", adminId));
    }
}
