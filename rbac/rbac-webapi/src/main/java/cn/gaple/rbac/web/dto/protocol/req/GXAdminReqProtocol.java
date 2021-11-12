package cn.gaple.rbac.web.dto.protocol.req;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
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
}
