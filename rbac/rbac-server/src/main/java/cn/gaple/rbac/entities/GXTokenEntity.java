package cn.gaple.rbac.entities;

import cn.gaple.rbac.core.constant.GXTokenConstant;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.entity.GXBaseEntity;
import cn.maple.core.framework.annotation.GXFieldComment;
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
public class GXTokenEntity extends GXBaseEntity {
    @GXFieldComment(zhDesc = "主键ID")
    private Integer id;

    @GXFieldComment(zhDesc = "token数据")
    private String token;

    @GXFieldComment("过期事件")
    private Integer expiredAt;

    @GXFieldComment("所属平台(admin、user)")
    private String platform;

    @GXFieldComment("目标(客户端)ID")
    private Integer targetId;

    @GXFieldComment("客户端IP")
    private String clientIp;

    @GXFieldComment(zhDesc = "扩展预留信息")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Dict ext;
}
