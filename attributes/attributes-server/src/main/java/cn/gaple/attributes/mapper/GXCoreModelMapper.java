package cn.gaple.attributes.mapper;

import cn.gaple.attributes.builder.GXCoreModelBuilder;
import cn.gaple.attributes.entity.GXCoreModelModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface GXCoreModelMapper extends GXBaseMapper<GXCoreModelModel> {
    @SelectProvider(type = GXCoreModelBuilder.class, method = "getSearchCondition")
    @Result(column = "model_id", property = "model_id")
    @Result(column = "search_condition", property = "search_condition")
    Dict getSearchCondition(Dict param);
}
