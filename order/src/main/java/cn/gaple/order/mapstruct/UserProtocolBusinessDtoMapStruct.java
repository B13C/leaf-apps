package cn.gaple.order.mapstruct;

import cn.gaple.order.dto.UserReqBusinessDto;
import cn.gaple.order.dto.protocol.req.UserReqProtocol;
import com.geoxus.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProtocolBusinessDtoMapStruct extends GXBaseMapStruct<UserReqProtocol, UserReqBusinessDto> {
}
