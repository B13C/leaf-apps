package cn.gaple.attributes.entity;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@TableName("core_modules")
@EqualsAndHashCode(callSuper = false)
public class GXCoreModulesModel extends GXMyBatisModel implements Serializable {
    @TableId
    private Integer moduleId;

    private Integer parentId;

    private String moduleName;
}
