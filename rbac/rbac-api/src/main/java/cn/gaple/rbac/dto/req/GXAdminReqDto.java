package cn.gaple.rbac.dto.req;

import cn.gaple.rbac.core.constant.GXAdminConstant;
import cn.maple.core.framework.dto.req.GXBaseReqDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminReqDto extends GXBaseReqDto {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实名字
     */
    private String realName;

    /**
     * 账号状态
     */
    private Integer status;

    /**
     * 是否超级管理员  1、是  2、否
     */
    private Integer superAdmin = GXAdminConstant.NON_ADMINISTRATOR;

    /**
     * 租户ID
     */
    private String tenantId;
}
