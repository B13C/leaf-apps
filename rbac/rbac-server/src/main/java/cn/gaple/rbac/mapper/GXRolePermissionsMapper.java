package cn.gaple.rbac.mapper;

import cn.gaple.rbac.builder.GXRolePermissionsBuilder;
import cn.gaple.rbac.entities.GXRolePermissionsModel;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Mapper
public interface GXRolePermissionsMapper extends GXBaseMapper<GXRolePermissionsModel> {
    @SelectProvider(type = GXRolePermissionsBuilder.class, method = "getPermissionsByAdminId")
    Set<String> getPermissionsByAdminId(Long adminId);
}
