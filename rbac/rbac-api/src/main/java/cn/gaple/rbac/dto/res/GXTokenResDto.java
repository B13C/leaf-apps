package cn.gaple.rbac.dto.res;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.annotation.GXFieldComment;
import cn.maple.core.framework.dto.inner.res.GXBaseResDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXTokenResDto extends GXBaseResDto {
    @GXFieldComment(zhDesc = "主键ID")
    private Integer id;

    @GXFieldComment(zhDesc = "token数据")
    private String token;

    @GXFieldComment("过期时间")
    private Integer expiredAt;

    @GXFieldComment("所属平台(admin、user)")
    private String platform;

    @GXFieldComment("目标(客户端)ID")
    private Integer targetId;

    @GXFieldComment("客户端IP")
    private String clientIp;

    @GXFieldComment(zhDesc = "扩展预留信息")
    private Dict ext;
}
