package cn.gaple.rbac.web.dto.protocol.req;

import cn.gaple.rbac.service.GXAdminService;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import cn.maple.core.framework.util.GXSpringContextUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminReqProtocol extends GXBaseReqProtocol {
    @ApiModelProperty("用户名")
    @NotNull(message = "用户名必填")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("电子邮件")
    private String email;

    @ApiModelProperty("预留扩展数据")
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
