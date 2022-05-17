package cn.gaple.attributes.mapper;

import cn.gaple.attributes.builder.GXCoreModelAttributesBuilder;
import cn.gaple.attributes.entity.GXCoreModelAttributesModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface GXCoreModelAttributesMapper extends GXBaseMapper<GXCoreModelAttributesModel> {
    @SelectProvider(type = GXCoreModelAttributesBuilder.class, method = "getModelAttributesByCondition")
    List<Dict> getModelAttributesByCondition(Dict param);

    @SelectProvider(type = GXCoreModelAttributesBuilder.class, method = "checkCoreModelHasAttribute")
    Integer checkCoreModelHasAttribute(Dict param);
}
