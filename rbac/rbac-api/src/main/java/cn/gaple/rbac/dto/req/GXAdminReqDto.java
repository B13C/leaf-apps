package cn.gaple.rbac.dto.req;

import cn.gaple.rbac.dto.req.ext.GXAdminExtReqDto;
import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONUtil;
import cn.maple.core.framework.dto.inner.req.GXBaseReqDto;
import cn.maple.core.framework.util.GXValidatorUtil;
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
     * 是否超级管理员
     * 1:是
     * 2:否
     */
    private Integer superAdmin = 2;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 扩展数据
     */
    private Dict ext;

    @Override
    public void verify() {
        GXAdminExtReqDto adminExtReqDto = JSONUtil.toBean(JSONUtil.toJsonStr(ext), GXAdminExtReqDto.class);
        GXValidatorUtil.validateEntity(adminExtReqDto);
    }
}
