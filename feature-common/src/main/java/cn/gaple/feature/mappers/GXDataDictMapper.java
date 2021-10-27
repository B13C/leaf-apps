package cn.gaple.feature.mappers;

import cn.hutool.core.lang.Dict;
import com.geoxus.core.datasource.mapper.GXBaseMapper;
import cn.gaple.feature.builder.GXDataDictBuilder;
import cn.gaple.feature.entities.GXDataDictEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface GXDataDictMapper extends GXBaseMapper<GXDataDictEntity> {
    @SelectProvider(type = GXDataDictBuilder.class, method = "listOrSearchPage")
    List<Dict> listOrSearchPage(Dict condition);
}