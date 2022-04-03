package cn.gaple.rbac.web.dto.protocol.req;

import cn.gaple.rbac.service.GXAdminService;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import cn.maple.core.framework.util.GXSpringContextUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminReqProtocol extends GXBaseReqProtocol {
    @NotNull(message = "用户名必填")
    private String username;

    private String nickname;

    private String phone;

    private String email;

    private Dict ext;

    @Override
    protected void beforeRepair() {
        GXAdminService adminService = GXSpringContextUtils.getBean(GXAdminService.class);
        Dict status = adminService.getStatus(1111);
        super.beforeRepair();
    }

    @Override
    protected void beforeMapping(CopyOptions copyOptions) {
        super.beforeMapping(copyOptions);
    }

    @Override
    protected void afterMapping(Object source) {
        super.afterMapping(source);
    }

    @Override
    protected void afterRepair() {
        super.afterRepair();
    }
}
