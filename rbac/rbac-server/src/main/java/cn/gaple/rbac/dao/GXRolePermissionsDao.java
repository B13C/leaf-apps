package cn.gaple.rbac.dao;

import cn.gaple.rbac.entities.GXRolePermissionsEntity;
import cn.maple.core.datasource.dao.GXBaseDao;
import cn.gaple.rbac.dto.res.GXRolePermissionsResDto;
import cn.gaple.rbac.entities.GXRolePermissionsEntity;
import cn.gaple.rbac.mapper.GXRolePermissionsMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GXRolePermissionsDao extends GXBaseDao<GXRolePermissionsEntity, GXRolePermissionsMapper, GXRolePermissionsResDto> {
}
