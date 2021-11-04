package cn.gaple.rbac.dao;

import cn.maple.core.datasource.dao.GXBaseDao;
import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRolesEntity;
import cn.gaple.rbac.mapper.GXAdminRoleMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GXAdminRoleDao extends GXBaseDao<GXAdminRolesEntity, GXAdminRoleMapper, GXAdminRoleResDto> {
}
