package cn.gaple.common.mapper;

import cn.gaple.common.entity.GXCoreModelTableFieldEntity;
import cn.hutool.core.lang.Dict;
import cn.gaple.common.builder.GXCoreModelTableFieldBuilder;
import com.geoxus.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GXCoreModelTableFieldMapper extends GXBaseMapper<GXCoreModelTableFieldEntity> {
    @SelectProvider(type = GXCoreModelTableFieldBuilder.class, method = "getModelAttributesByCondition")
    List<Dict> getModelAttributesByCondition(Dict condition);
}
