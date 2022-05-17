package cn.gaple.rbac.dto.res;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.res.GXBaseDBResDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TbAdDBResDto extends GXBaseDBResDto {
    private Integer id;

    private String url;

    private Short status;

    private String position;

    @Override
    public void customizeProcess(Dict extraData) {
        super.customizeProcess(extraData);
    }
}
