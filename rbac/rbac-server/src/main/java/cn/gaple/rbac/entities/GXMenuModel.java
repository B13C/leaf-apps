package cn.gaple.rbac.entities;

import cn.gaple.rbac.core.constant.GXMenuConstant;
import cn.gaple.rbac.core.enums.GXMenuTypeEnum;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.model.GXMyBatisModel;
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
public class GXMenuModel extends GXMyBatisModel {
    private Integer id;

    private String name;

    private String pid;

    private GXMenuTypeEnum type;

    private String controllerName;

    private String actionName;

    private String code;

    private String tenantId;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Dict ext;
}
