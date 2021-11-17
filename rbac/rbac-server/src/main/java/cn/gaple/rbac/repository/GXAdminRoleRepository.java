package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXAdminRoleDao;
import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRoleEntity;
import cn.gaple.rbac.mapper.GXAdminRoleMapper;
import cn.maple.core.datasource.repository.GXBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXAdminRoleRepository extends GXBaseRepository<GXAdminRoleMapper, GXAdminRoleEntity, GXAdminRoleDao, GXAdminRoleResDto, Integer> {
}
