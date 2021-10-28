package cn.gaple.extra.feature.mappers;

import cn.gaple.extra.feature.builder.GXRegionBuilder;
import cn.gaple.extra.feature.entities.GXRegionEntity;
import cn.hutool.core.lang.Dict;
import com.geoxus.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface GXRegionMapper extends GXBaseMapper<GXRegionEntity> {
    @SelectProvider(type = GXRegionBuilder.class, method = "areaInfo")
    Dict areaInfo(Dict param);
}