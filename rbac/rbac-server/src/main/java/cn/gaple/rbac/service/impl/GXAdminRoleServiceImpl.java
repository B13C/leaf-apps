package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.GXAdminRoleDao;
import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRolesEntity;
import cn.gaple.rbac.mapper.GXAdminRoleMapper;
import cn.gaple.rbac.service.GXAdminRoleService;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.impl.GXDBBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GXAdminRoleServiceImpl extends
        GXDBBaseServiceImpl<GXAdminRoleMapper, GXAdminRolesEntity, GXAdminRoleDao, GXAdminRoleResDto> implements GXAdminRoleService {
    @Override
    public Set<String> getAdminRoles(Long adminId) {
        final Dict condition = Dict.create().set("admin_id", adminId);
        return baseDao.getAdminRoles(condition);
    }

    public long create(GXAdminRolesEntity target, Dict param) {
        baseDao.save(target);
        return target.getId();
    }
}
