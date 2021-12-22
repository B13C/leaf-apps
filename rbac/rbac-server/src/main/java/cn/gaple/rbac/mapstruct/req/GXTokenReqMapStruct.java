package cn.gaple.rbac.mapstruct.req;

import cn.gaple.rbac.dto.req.GXTokenReqDto;
import cn.gaple.rbac.entities.GXTokenModel;
import cn.maple.core.framework.mapstruct.GXBaseMapStruct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GXTokenReqMapStruct extends GXBaseMapStruct<GXTokenReqDto, GXTokenModel> {
}
