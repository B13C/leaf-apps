package cn.gaple.attributes.entity;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("core_attributes_enums")
@EqualsAndHashCode(callSuper = false)
public class GXCoreAttributesEnumsModel extends GXMyBatisModel implements Serializable {
    @TableId
    private Integer attributeEnumId;

    private Integer attributeId;

    private Integer coreModelId;

    private String valueEnum;

    private String showName;
}
