package cn.gaple.order.builder.dto;

import cn.gaple.core.framework.dto.GXBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressDto extends GXBaseDto {
    private Long userId;

    private String username;
}
