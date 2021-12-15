package cn.gaple.rbac.mapstruct.res;

import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminModel;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GXAdminResMapStruct extends GXBaseMapStruct<GXAdminModel, GXAdminResDto> {
}
