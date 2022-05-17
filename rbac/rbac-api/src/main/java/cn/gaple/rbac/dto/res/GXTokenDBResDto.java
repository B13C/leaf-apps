package cn.gaple.rbac.dto.res;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.res.GXBaseDBResDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXTokenDBResDto extends GXBaseDBResDto {
    private Integer id;

    private String token;

    private Integer expiredAt;

    private String platform;

    private Integer targetId;

    private String clientIp;

    private Dict ext;
}
