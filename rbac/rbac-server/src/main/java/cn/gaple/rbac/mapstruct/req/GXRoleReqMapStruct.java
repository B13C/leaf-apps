package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXRoleReqDto;
import cn.gaple.rbac.entities.GXRoleEntity;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXRoleReqMapStruct extends GXBaseMapStruct<GXRoleReqDto, GXRoleEntity> {
}
