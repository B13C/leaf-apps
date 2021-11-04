package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXAdminRolesReqDto;
import cn.gaple.rbac.entities.GXAdminRolesEntity;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXAdminRoleReqMapStruct extends GXBaseMapStruct<GXAdminRolesReqDto, GXAdminRolesEntity> {
}
