package cn.gaple.rbac.mapper;

import cn.gaple.rbac.builder.GXAdminRoleBuilder;
import cn.gaple.rbac.entities.GXAdminRoleModel;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Mapper
public interface GXAdminRoleMapper extends GXBaseMapper<GXAdminRoleModel> {
    @SelectProvider(type = GXAdminRoleBuilder.class, method = "getAdminRoles")
    Set<String> getAdminRoles(Dict condition);
}
