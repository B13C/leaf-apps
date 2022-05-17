package cn.gaple.extra.feature.mappers;

import cn.gaple.extra.feature.builder.GXMediaLibraryBuilder;
import cn.gaple.extra.feature.entities.GXMediaLibraryModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface GXMediaLibraryMapper extends GXBaseMapper<GXMediaLibraryModel> {
    @SelectProvider(type = GXMediaLibraryBuilder.class, method = "listOrSearch")
    @ResultMap("mediaResult")
    <R> List<R> listOrSearchPage(IPage<R> page, Dict param);

    @SelectProvider(type = GXMediaLibraryBuilder.class, method = "detail")
    Dict detail(Dict param);

    @DeleteProvider(type = GXMediaLibraryBuilder.class, method = "deleteByCondition")
    boolean deleteByCondition(Dict param);

    @SelectProvider(type = GXMediaLibraryBuilder.class, method = "getMediaByCondition")
    List<Dict> getMediaByCondition(Dict param);
}
