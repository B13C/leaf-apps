package cn.gaple.order.mapstruct;

import cn.gaple.order.dto.protocol.res.GoodsResProtocol;
import cn.gaple.order.dto.res.GoodsResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GoodsResMapstruct {
    @Mapping(source = "goodsName", target = "goodsNameXX")
    GoodsResProtocol dtoToProtocol(GoodsResDto dto);
}
