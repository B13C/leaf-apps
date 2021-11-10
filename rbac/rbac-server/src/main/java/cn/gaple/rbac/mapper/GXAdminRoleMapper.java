package cn.gaple.rbac.mapper;

import cn.gaple.rbac.builder.GXAdminRoleBuilder;
import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRoleEntity;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Mapper
public interface GXAdminRoleMapper extends GXBaseMapper<GXAdminRoleEntity, GXAdminRoleResDto> {
    @SelectProvider(type = GXAdminRoleBuilder.class, method = "getAdminRoles")
    Set<String> getAdminRoles(Dict condition);
}
