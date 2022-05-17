package cn.gaple.attributes.mapper;

import cn.gaple.attributes.builder.GXCoreConfigBuilder;
import cn.gaple.attributes.entity.GXCoreConfigModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface GXCoreConfigMapper extends GXBaseMapper<GXCoreConfigModel> {
    @SelectProvider(type = GXCoreConfigBuilder.class, method = "listOrSearch")
    <R> List<R> listOrSearchPage(IPage<R> page, Dict param);

    @SelectProvider(type = GXCoreConfigBuilder.class, method = "detail")
    Dict detail(Dict param);
}
