package cn.gaple.attributes.entity;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@TableName("core_model_attributes_permission")
@EqualsAndHashCode(callSuper = false)
public class GXCoreModelAttributesPermissionModel extends GXMyBatisModel {
    @TableId
    private Integer attributePermissionId;

    private Integer modelAttributesId;

    private String deny;
}
