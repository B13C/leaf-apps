package cn.gaple.order.dto.res;

import com.geoxus.core.framework.dto.GXBaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsResDto extends GXBaseDto {
    private String goodsName;

    private String goodsPrice;
}
