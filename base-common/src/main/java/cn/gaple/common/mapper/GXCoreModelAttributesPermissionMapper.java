package cn.gaple.common.mapper;

import cn.gaple.common.entity.GXCoreModelAttributesPermissionEntity;
import cn.hutool.core.lang.Dict;
import cn.gaple.common.builder.GXCoreModelAttributesPermissionsBuilder;
import com.geoxus.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Mapper
@Primary
public interface GXCoreModelAttributesPermissionMapper extends GXBaseMapper<GXCoreModelAttributesPermissionEntity> {
    @SelectProvider(type = GXCoreModelAttributesPermissionsBuilder.class, method = "getModelAttributePermissionByCondition")
    List<Dict> getModelAttributePermissionByCondition(Dict param);
}
