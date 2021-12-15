package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXTokenReqDto;
import cn.gaple.rbac.entities.GXTokenModel;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GXTokenReqMapStruct extends GXBaseMapStruct<GXTokenReqDto, GXTokenModel> {
}
