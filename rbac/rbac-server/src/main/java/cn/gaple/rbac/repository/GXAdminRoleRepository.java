package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXAdminRoleDao;
import cn.gaple.rbac.entities.GXAdminRoleModel;
import cn.gaple.rbac.mapper.GXAdminRoleMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXAdminRoleRepository extends GXMyBatisRepository<GXAdminRoleMapper, GXAdminRoleModel, GXAdminRoleDao, Integer> {
}
