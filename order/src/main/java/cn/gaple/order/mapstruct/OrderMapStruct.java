package cn.gaple.order.mapstruct;

import cn.gaple.order.dto.protocol.res.OrderResProtocol;
import cn.gaple.order.dto.res.OrderResDto;
import com.geoxus.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = GoodsResMapstruct.class)
public interface OrderMapStruct extends GXBaseMapStruct<OrderResDto, OrderResProtocol> {
    /**
     * DTO转换为Entity
     *
     * @param dtoList WEB请求对象
     * @return E
     */
    @Mapping(source = "goodsResDtoList", target = "goodsResProtocols")
    List<OrderResProtocol> dtoListToProtocolList(List<OrderResDto> dtoList);
}
