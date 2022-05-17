package cn.gaple.attributes.entity;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@TableName("core_model_table_field")
@EqualsAndHashCode(callSuper = false)
@Data
public class GXCoreModelTableFieldModel extends GXMyBatisModel implements Serializable {
    @TableId
    private Integer coreModelDbFieldId;

    private String dbFieldName;

    private String coreModelId;
}
