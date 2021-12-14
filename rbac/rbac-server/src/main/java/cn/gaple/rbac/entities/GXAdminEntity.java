package cn.gaple.rbac.entities;

import cn.gaple.rbac.core.constant.GXAdminConstant;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.po.GXBasePO;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@TableName(GXAdminConstant.TABLE_NAME)
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GXAdminEntity extends GXBasePO {
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
     * 密码加密盐
     */
    private String salt;

    /**
     * 是否超级管理员
     */
    private Integer superAdmin;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 扩展预留信息
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Dict ext;
}
