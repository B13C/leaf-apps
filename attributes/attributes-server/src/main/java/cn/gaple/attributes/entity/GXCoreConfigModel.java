package cn.gaple.attributes.entity;

import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@TableName("core_config")
@EqualsAndHashCode(callSuper = false)
public class GXCoreConfigModel extends GXMyBatisModel {
    @TableId
    private Integer configId;

    private Integer coreModelId;

    @NotBlank()
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String paramKey;

    @NotBlank()
    private String paramValue;

    private Integer status;

    private String remark;
}
