package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXAdminPermissionsReqDto;
import cn.gaple.rbac.entities.GXAdminPermissionsModel;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXAdminPermissionsReqMapStruct extends GXBaseMapStruct<GXAdminPermissionsReqDto, GXAdminPermissionsModel> {
}
