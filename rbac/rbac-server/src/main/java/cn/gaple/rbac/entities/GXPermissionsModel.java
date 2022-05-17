package cn.gaple.rbac.entities;

import cn.gaple.rbac.core.constant.GXPermissionsConstant;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@TableName(GXPermissionsConstant.TABLE_NAME)
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GXPermissionsModel extends GXMyBatisModel {
    private Integer id;

    private String code;

    private String tenantId;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Dict ext;
}
