package cn.gaple.attributes.mapper;

import cn.gaple.attributes.builder.GXCoreAttributesBuilder;
import cn.gaple.attributes.entity.GXCoreAttributesModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface GXCoreAttributesMapper extends GXBaseMapper<GXCoreAttributesModel> {
    @SelectProvider(type = GXCoreAttributesBuilder.class, method = "listOrSearch")
    <R> List<R> listOrSearchPage(IPage<R> page, Dict param);

    Dict detail(Dict param);
}
