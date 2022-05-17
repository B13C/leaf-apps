package cn.gaple.rbac.mapper;

import cn.gaple.rbac.entities.GXPermissionsModel;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface GXPermissionsMapper extends GXBaseMapper<GXPermissionsModel> {
}
