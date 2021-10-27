package cn.gaple.order.dto.res;

import com.geoxus.core.framework.dto.GXBaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResDto extends GXBaseDto {
    private String orderSn;

    private String totalPrice;

    private List<GoodsResDto> goodsResDtoList;
}
