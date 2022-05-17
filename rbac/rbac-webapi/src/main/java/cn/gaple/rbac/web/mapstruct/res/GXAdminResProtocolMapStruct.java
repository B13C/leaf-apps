package cn.gaple.rbac.web.mapstruct.res;

import cn.gaple.rbac.dto.res.GXAdminDBResDto;
import cn.gaple.rbac.web.dto.protocol.res.GXAdminResProtocol;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GXAdminResProtocolMapStruct extends GXBaseMapStruct<GXAdminDBResDto, GXAdminResProtocol> {
}
