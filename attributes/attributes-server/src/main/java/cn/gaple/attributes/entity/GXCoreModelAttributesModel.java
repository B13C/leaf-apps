package cn.gaple.attributes.entity;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("core_model_attributes")
@EqualsAndHashCode(callSuper = false)
public class GXCoreModelAttributesModel extends GXMyBatisModel implements Serializable {
    @TableId("model_attributes_id")
    private Integer modelAttributesId;

    private String dbFieldName;

    private int coreModelId;

    private int attributeId;

    private String showName;

    private int required;

    private String validationExpression;

    private int forceValidation;

    private String defaultValue;

    private String ext;
}
