package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.dto.req.GXAdminLoginReqDto;
import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.service.GXAdminService;
import cn.gaple.rbac.web.dto.protocol.req.GXAdminLoginReqProtocol;
import cn.gaple.rbac.web.dto.protocol.req.GXAdminReqProtocol;
import cn.gaple.rbac.web.dto.protocol.req.query.GXAdminQueryObjectProtocol;
import cn.gaple.rbac.web.dto.protocol.res.GXAdminResProtocol;
import cn.gaple.rbac.web.mapstruct.req.GXAdminLoginReqProtocolMapStruct;
import cn.gaple.rbac.web.mapstruct.req.GXAdminReqProtocolMapStruct;
import cn.gaple.rbac.web.mapstruct.res.GXAdminResProtocolMapStruct;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.annotation.GXRequestBody;
import cn.maple.core.framework.controller.GXBaseController;
import cn.maple.core.framework.dto.inner.GXBaseQueryParamInnerDto;
import cn.maple.core.framework.dto.protocol.res.GXPaginationResProtocol;
import cn.maple.core.framework.dto.res.GXPaginationResDto;
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
    private GXAdminLoginReqProtocolMapStruct adminLoginReqMapStruct;

    @Resource
    private GXAdminReqProtocolMapStruct adminReqMapStruct;

    @Resource
    private GXAdminResProtocolMapStruct adminResMapStruct;

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
        GXAdminReqDto adminReqDto = adminReqMapStruct.sourceToTarget(reqProtocol);
        Integer adminId = adminService.updateOrCreate(adminReqDto);
        return GXResultUtils.ok(Dict.create().set("adminId", adminId));
    }

    @PostMapping("/pagination")
    public GXResultUtils<GXPaginationResProtocol<GXAdminResProtocol>> pagination(@GXRequestBody @Validated GXAdminQueryObjectProtocol queryObjectProtocol) {
        GXBaseQueryParamInnerDto paramReqDto = convertSourceToTarget(queryObjectProtocol, GXBaseQueryParamInnerDto.class);
        GXPaginationResDto<GXAdminResDto> pagination = adminService.pagination(paramReqDto);
        GXPaginationResProtocol<GXAdminResProtocol> paginationResProtocol =
                convertPaginationResToProtocol(pagination, GXAdminResProtocol.class);
        return GXResultUtils.ok(paginationResProtocol);
    }
}
