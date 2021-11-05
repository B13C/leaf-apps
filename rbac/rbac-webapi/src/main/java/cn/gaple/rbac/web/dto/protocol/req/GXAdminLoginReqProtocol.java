package cn.gaple.rbac.web.dto.protocol.req;

import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminLoginReqProtocol extends GXBaseReqProtocol {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名必填")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码必填")
    @Range(min = 24)
    private String password;

    /**
     * 验证码
     */
    private String captcha;

    /**
     * 验证类型
     * 1、手机验证码
     * 2、邮箱
     */
    private String auType;
}
