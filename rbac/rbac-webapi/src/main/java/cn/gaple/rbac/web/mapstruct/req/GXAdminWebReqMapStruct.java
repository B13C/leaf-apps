package cn.gaple.rbac.web.mapstruct.req;

import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.web.dto.protocol.req.GXAdminReqProtocol;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GXAdminWebReqMapStruct extends GXBaseMapStruct<GXAdminReqProtocol, GXAdminReqDto> {
}
