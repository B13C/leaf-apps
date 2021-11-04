package cn.gaple.rbac.dao;

import cn.maple.core.datasource.dao.GXBaseDao;
import cn.gaple.rbac.dto.res.GXAdminPermissionsResDto;
import cn.gaple.rbac.entities.GXAdminPermissionsEntity;
import cn.gaple.rbac.mapper.GXAdminPermissionsMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GXAdminPermissionsDao extends GXBaseDao<GXAdminPermissionsEntity, GXAdminPermissionsMapper, GXAdminPermissionsResDto> {
}
