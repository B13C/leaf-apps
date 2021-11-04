package cn.gaple.rbac.web.controller.backend;

import cn.gaple.rbac.dto.req.GXAdminPermissionsReqDto;
import cn.gaple.rbac.entities.GXAdminPermissionsEntity;
import cn.gaple.rbac.mapstruct.req.GXAdminPermissionsReqMapStruct;
import cn.gaple.rbac.service.GXAdminPermissionsService;
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
 * 管理员权限管理
 */
@RestController
@RequestMapping("/admin-permissions/backend")
public class GXAdminPermissionsController implements GXBaseController {
    @Resource
    private GXAdminPermissionsService adminPermissionsService;

    @Resource
    private GXAdminPermissionsReqMapStruct adminPermissionsMapStruct;

    /**
     * 新增管理员权限
     *
     * @param source 请求参数
     * @return GXResultUtils
     */
    //@RequiresRoles("super_admin")
    @PostMapping("create")
    public GXResultUtils<Dict> create(@GXRequestBody @Validated GXAdminPermissionsReqDto source) {
        GXAdminPermissionsEntity entity = adminPermissionsMapStruct.sourceToTarget(source);
        long id = adminPermissionsService.create(entity, Dict.create());
        return GXResultUtils.ok(Dict.create().set("id", id));
    }
}
