package cn.gaple.rbac.entities;

import cn.gaple.rbac.core.constant.GXMenuConstant;
import cn.gaple.rbac.core.enums.GXMenuTypeEnum;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.po.GXBasePO;
import cn.maple.core.framework.annotation.GXFieldComment;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@TableName(GXMenuConstant.TABLE_NAME)
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GXMenuEntity extends GXBasePO {
    @GXFieldComment(zhDesc = "主键ID")
    private Integer id;

    @GXFieldComment(zhDesc = "菜单名字")
    private String name;

    @GXFieldComment(zhDesc = "父级ID")
    private String pid;

    @GXFieldComment(zhDesc = "按钮类型")
    private GXMenuTypeEnum type;

    @GXFieldComment(zhDesc = "资源控制器名字")
    private String controllerName;

    @GXFieldComment(zhDesc = "资源控制器动作名字")
    private String actionName;

    @GXFieldComment(zhDesc = "资源Code")
    private String code;

    @GXFieldComment("租户ID")
    private String tenantId;

    @GXFieldComment(zhDesc = "扩展预留信息")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Dict ext;
}
