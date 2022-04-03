package cn.gaple.rbac.dto.res;

import cn.maple.core.framework.dto.res.GXBaseResDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TbAdResDto extends GXBaseResDto {
    private Integer id;

    private String url;

    private Short status;

    private String position;
}
