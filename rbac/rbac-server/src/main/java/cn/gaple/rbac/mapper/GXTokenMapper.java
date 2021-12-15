package cn.gaple.rbac.mapper;

import cn.gaple.rbac.dto.res.GXTokenResDto;
import cn.gaple.rbac.entities.GXTokenModel;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GXTokenMapper extends GXBaseMapper<GXTokenModel, GXTokenResDto> {
}
