package cn.gaple.extra.feature.mappers;

import cn.gaple.extra.feature.builder.GXMediaLibraryBuilder;
import cn.gaple.extra.feature.entities.GXMediaLibraryEntity;
import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.geoxus.core.datasource.handler.GXJsonToListTypeHandler;
import com.geoxus.core.datasource.handler.GXJsonToMapTypeHandler;
import com.geoxus.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GXMediaLibraryMapper extends GXBaseMapper<GXMediaLibraryEntity> {
    @SelectProvider(type = GXMediaLibraryBuilder.class, method = "listOrSearch")
    @ResultMap("mediaResult")
    <R> List<R> listOrSearchPage(IPage<R> page, Dict param);

    @SelectProvider(type = GXMediaLibraryBuilder.class, method = "detail")
    @Results(id = "mediaResult", value = {
            @Result(column = "custom_properties", property = "customProperties", typeHandler = GXJsonToListTypeHandler.class),
            @Result(column = "responsive_images", property = "responsiveImages", typeHandler = GXJsonToMapTypeHandler.class),
            @Result(column = "manipulations", property = "manipulations", typeHandler = GXJsonToListTypeHandler.class)
    })
    Dict detail(Dict param);

    @DeleteProvider(type = GXMediaLibraryBuilder.class, method = "deleteByCondition")
    boolean deleteByCondition(Dict param);

    @SelectProvider(type = GXMediaLibraryBuilder.class, method = "getMediaByCondition")
    List<Dict> getMediaByCondition(Dict param);
}
