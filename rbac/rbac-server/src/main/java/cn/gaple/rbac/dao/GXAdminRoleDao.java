package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRolesEntity;
import cn.gaple.rbac.mapper.GXAdminRoleMapper;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.dao.GXBaseDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Component
public class GXAdminRoleDao extends GXBaseDao<GXAdminRoleMapper, GXAdminRolesEntity, GXAdminRoleResDto> {
    public Set<String> getAdminRoles(Dict condition) {
        return baseMapper.getAdminRoles(condition);
    }
}
