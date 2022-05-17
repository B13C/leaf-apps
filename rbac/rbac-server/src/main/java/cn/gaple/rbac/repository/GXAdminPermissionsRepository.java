package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXAdminPermissionsDao;
import cn.gaple.rbac.entities.GXAdminPermissionsModel;
import cn.gaple.rbac.mapper.GXAdminPermissionsMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Set;

@Repository
public class GXAdminPermissionsRepository extends GXMyBatisRepository<GXAdminPermissionsMapper, GXAdminPermissionsModel, GXAdminPermissionsDao, Integer> {
    @Resource
    private GXAdminPermissionsDao adminPermissionsDao;

    public Set<String> getPermissionsByAdminId(Long adminId) {
        return adminPermissionsDao.getPermissionsByAdminId(adminId);
    }

    public void save(GXAdminPermissionsModel target) {
        adminPermissionsDao.save(target);
    }
}
