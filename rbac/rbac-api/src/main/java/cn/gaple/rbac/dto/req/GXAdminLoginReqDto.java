package cn.gaple.rbac.dto.req;

import cn.maple.core.framework.dto.req.GXBaseReqDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminLoginReqDto extends GXBaseReqDto {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码必填")
    private String password;

    /**
     * 验证码
     */
    //@NotBlank(message = "验证码")
    private String captcha;

    /**
     * 验证码的类型
     */
    //@NotBlank(message = "验证码的类型")
    private String auType;
}
