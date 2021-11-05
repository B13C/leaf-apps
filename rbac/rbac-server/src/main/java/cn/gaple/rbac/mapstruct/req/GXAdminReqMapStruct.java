package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXAdminReqMapStruct extends GXBaseMapStruct<GXAdminReqDto, GXAdminEntity> {
}
