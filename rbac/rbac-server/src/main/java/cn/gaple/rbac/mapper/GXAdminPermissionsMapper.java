package cn.gaple.rbac.mapper;

import cn.gaple.rbac.builder.GXAdminPermissionsBuilder;
import cn.gaple.rbac.entities.GXAdminPermissionsModel;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Mapper
@Component
public interface GXAdminPermissionsMapper extends GXBaseMapper<GXAdminPermissionsModel> {
    @SelectProvider(type = GXAdminPermissionsBuilder.class, method = "getPermissionsByAdminId")
    Set<String> getPermissionsByAdminId(Long adminId);
}
