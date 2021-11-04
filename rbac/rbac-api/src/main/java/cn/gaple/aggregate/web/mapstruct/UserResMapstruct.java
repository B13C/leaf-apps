package cn.gaple.aggregate.web.mapstruct;

import cn.gaple.aggregate.web.dto.protocol.req.UserReqProtocol;
import cn.gaple.aggregate.web.dto.protocol.res.UserResProtocol;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserResMapstruct extends GXBaseMapStruct<UserReqProtocol, UserResProtocol> {
    @Override
    @Mapping(source = "password", target = "password")
    UserReqProtocol targetToSource(UserResProtocol userResProtocol);
}
