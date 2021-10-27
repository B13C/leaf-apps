package cn.gaple.common.mapper;

import cn.gaple.common.entity.GXCoreModelAttributesEntity;
import cn.hutool.core.lang.Dict;
import cn.gaple.common.builder.GXCoreModelAttributesBuilder;
import com.geoxus.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface GXCoreModelAttributesMapper extends GXBaseMapper<GXCoreModelAttributesEntity> {
    @SelectProvider(type = GXCoreModelAttributesBuilder.class, method = "getModelAttributesByCondition")
    List<Dict> getModelAttributesByCondition(Dict param);

    @SelectProvider(type = GXCoreModelAttributesBuilder.class, method = "checkCoreModelHasAttribute")
    Integer checkCoreModelHasAttribute(Dict param);
}
