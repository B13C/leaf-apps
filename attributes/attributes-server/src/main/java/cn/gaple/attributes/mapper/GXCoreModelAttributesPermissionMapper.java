package cn.gaple.attributes.mapper;

import cn.gaple.attributes.builder.GXCoreModelAttributesPermissionsBuilder;
import cn.gaple.attributes.entity.GXCoreModelAttributesPermissionModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper
@Primary
public interface GXCoreModelAttributesPermissionMapper extends GXBaseMapper<GXCoreModelAttributesPermissionModel> {
    @SelectProvider(type = GXCoreModelAttributesPermissionsBuilder.class, method = "getModelAttributePermissionByCondition")
    List<Dict> getModelAttributePermissionByCondition(Dict param);
}
