package cn.gaple.order.mapstruct;

import cn.gaple.core.framework.mapstruct.GXBaseMapStruct;
import cn.gaple.order.dto.protocol.req.UserReqProtocol;
import cn.gaple.order.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProtocolMapstruct extends GXBaseMapStruct<UserReqProtocol, UserEntity> {
}
