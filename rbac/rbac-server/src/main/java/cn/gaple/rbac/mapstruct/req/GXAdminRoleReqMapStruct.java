package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXAdminRoleReqDto;
import cn.gaple.rbac.entities.GXAdminRoleEntity;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXAdminRoleReqMapStruct extends GXBaseMapStruct<GXAdminRoleReqDto, GXAdminRoleEntity> {
}
