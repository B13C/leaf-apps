package cn.gaple.extra.feature.mappers;

import cn.gaple.extra.feature.builder.GXRegionBuilder;
import cn.gaple.extra.feature.entities.GXRegionModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface GXRegionMapper extends GXBaseMapper<GXRegionModel> {
    @SelectProvider(type = GXRegionBuilder.class, method = "areaInfo")
    Dict areaInfo(Dict param);
}