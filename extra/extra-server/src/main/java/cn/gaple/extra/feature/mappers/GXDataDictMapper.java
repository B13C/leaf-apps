package cn.gaple.extra.feature.mappers;

import cn.gaple.extra.feature.builder.GXDataDictBuilder;
import cn.gaple.extra.feature.entities.GXDataDictModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface GXDataDictMapper extends GXBaseMapper<GXDataDictModel> {
    @SelectProvider(type = GXDataDictBuilder.class, method = "listOrSearchPage")
    List<Dict> listOrSearchPage(Dict condition);
}