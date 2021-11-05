package cn.gaple.rbac.web.dto.protocol.req;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserReqProtocol extends GXBaseReqProtocol {
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 预留扩展信息
     */
    private Dict ext;

    @Valid
    private UserDetailProtocol userDetail;
}
