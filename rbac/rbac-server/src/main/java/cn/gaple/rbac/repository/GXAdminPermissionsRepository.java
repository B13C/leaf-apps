package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXAdminPermissionsDao;
import cn.gaple.rbac.dto.res.GXAdminPermissionsResDto;
import cn.gaple.rbac.entities.GXAdminPermissionsEntity;
import cn.gaple.rbac.mapper.GXAdminPermissionsMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Set;

@Repository
public class GXAdminPermissionsRepository extends GXMyBatisRepository<GXAdminPermissionsMapper, GXAdminPermissionsEntity, GXAdminPermissionsDao, GXAdminPermissionsResDto, Integer> {
    @Resource
    private GXAdminPermissionsDao adminPermissionsDao;

    public Set<String> getPermissionsByAdminId(Long adminId) {
        return adminPermissionsDao.getPermissionsByAdminId(adminId);
    }

    public void save(GXAdminPermissionsEntity target) {
        adminPermissionsDao.save(target);
    }
}
