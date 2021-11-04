package cn.gaple.rbac.entities;

import cn.gaple.rbac.constant.GXRolePermissionsConstant;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.entity.GXBaseEntity;
import cn.maple.core.framework.annotation.GXFieldComment;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@TableName(GXRolePermissionsConstant.TABLE_NAME)
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GXRolePermissionsEntity extends GXBaseEntity implements Serializable {
    @GXFieldComment(zhDesc = "主键ID")
    private Integer id;

    @GXFieldComment(zhDesc = "角色ID")
    private Integer roleId;

    @GXFieldComment(zhDesc = "权限ID")
    private Integer permissionId;

    @GXFieldComment("租户ID")
    private String tenantId;

    @GXFieldComment(zhDesc = "扩展预留信息")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Dict ext;
}
