package cn.gaple.attributes.entity;

import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("core_model")
@EqualsAndHashCode(callSuper = false)
public class GXCoreModelModel extends GXMyBatisModel implements Serializable {
    @TableId
    private Integer modelId;

    private Integer moduleId;

    private String tableName;

    private String modelShow;

    private String modelIdentification;

    private String searchCondition;

    @TableField(exist = false)
    private List<Dict> coreAttributes;
}
