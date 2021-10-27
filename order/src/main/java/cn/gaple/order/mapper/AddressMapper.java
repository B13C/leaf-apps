package cn.gaple.order.mapper;

import cn.gaple.order.builder.AddressBuilder;
import cn.gaple.order.builder.dto.AddressDto;
import cn.gaple.order.dto.protocol.res.UserResProtocol;
import cn.gaple.order.entity.UserEntity;
import com.geoxus.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AddressMapper extends GXBaseMapper<UserEntity> {
    @SelectProvider(type = AddressBuilder.class, method = "getListByCondition")
    UserResProtocol getListByCondition(AddressDto dto);
}
