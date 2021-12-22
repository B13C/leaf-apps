package cn.gaple.rbac.mapstruct.res;

import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminModel;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXAdminResMapStruct extends GXBaseMapStruct<GXAdminModel, GXAdminResDto> {
}
