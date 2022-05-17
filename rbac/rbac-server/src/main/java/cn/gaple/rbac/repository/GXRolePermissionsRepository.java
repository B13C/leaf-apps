package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXRolePermissionsDao;
import cn.gaple.rbac.entities.GXRolePermissionsModel;
import cn.gaple.rbac.mapper.GXRolePermissionsMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Set;

@Repository
public class GXRolePermissionsRepository extends
        GXMyBatisRepository<GXRolePermissionsMapper, GXRolePermissionsModel, GXRolePermissionsDao, Integer> {
    @Resource
    private GXRolePermissionsDao rolePermissionsDao;

    public Set<String> getPermissionsByAdminId(Long adminId) {
        return rolePermissionsDao.getPermissionsByAdminId(adminId);
    }
}
