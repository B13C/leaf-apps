package cn.gaple.rbac.entities;

import cn.gaple.rbac.core.constant.GXTokenConstant;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.model.GXMyBatisModel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@TableName(GXTokenConstant.TABLE_NAME)
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GXTokenModel extends GXMyBatisModel {
    private Integer id;

    private String token;

    private Integer expiredAt;

    private String platform;

    private Integer targetId;

    private String clientIp;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Dict ext;
}
