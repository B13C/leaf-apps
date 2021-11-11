package cn.gaple.rbac.web.mapstruct.req;

import cn.gaple.rbac.dto.req.GXAdminLoginReqDto;
import cn.gaple.rbac.web.dto.protocol.req.GXAdminLoginReqProtocol;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GXAdminLoginReqProtocolMapStruct extends GXBaseMapStruct<GXAdminLoginReqProtocol, GXAdminLoginReqDto> {
}
