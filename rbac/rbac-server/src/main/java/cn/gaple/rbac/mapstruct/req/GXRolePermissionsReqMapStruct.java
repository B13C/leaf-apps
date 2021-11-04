package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXRolePermissionsReqDto;
import cn.gaple.rbac.entities.GXRolePermissionsEntity;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXRolePermissionsReqMapStruct extends GXBaseMapStruct<GXRolePermissionsReqDto, GXRolePermissionsEntity> {
}
