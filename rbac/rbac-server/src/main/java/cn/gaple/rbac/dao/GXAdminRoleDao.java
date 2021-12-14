package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRoleEntity;
import cn.gaple.rbac.mapper.GXAdminRoleMapper;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GXAdminRoleDao extends GXMyBatisDao<GXAdminRoleMapper, GXAdminRoleEntity, GXAdminRoleResDto , Integer> {
    public Set<String> getAdminRoles(Dict condition) {
        return baseMapper.getAdminRoles(condition);
    }
}
