package cn.gaple.feature.mappers;

import cn.gaple.feature.builder.GXRegionBuilder;
import cn.hutool.core.lang.Dict;
import com.geoxus.core.datasource.mapper.GXBaseMapper;
import cn.gaple.feature.entities.GXRegionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface GXRegionMapper extends GXBaseMapper<GXRegionEntity> {
    @SelectProvider(type = GXRegionBuilder.class, method = "areaInfo")
    Dict areaInfo(Dict param);
}