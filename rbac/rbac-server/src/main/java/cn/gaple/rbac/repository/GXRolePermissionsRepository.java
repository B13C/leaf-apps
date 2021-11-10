package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXRolePermissionsDao;
import cn.gaple.rbac.dto.res.GXRolePermissionsResDto;
import cn.gaple.rbac.entities.GXRolePermissionsEntity;
import cn.maple.core.datasource.repository.GXBaseRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Set;

@Repository
public class GXRolePermissionsRepository implements GXBaseRepository<GXRolePermissionsEntity, GXRolePermissionsResDto> {
    @Resource
    private GXRolePermissionsDao rolePermissionsDao;

    public Set<String> getPermissionsByAdminId(Long adminId) {
        return rolePermissionsDao.getPermissionsByAdminId(adminId);
    }
}
