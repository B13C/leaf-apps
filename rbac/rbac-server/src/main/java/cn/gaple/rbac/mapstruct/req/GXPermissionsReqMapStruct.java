package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXPermissionsReqDto;
import cn.gaple.rbac.entities.GXPermissionsModel;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXPermissionsReqMapStruct extends GXBaseMapStruct<GXPermissionsReqDto, GXPermissionsModel> {
}
