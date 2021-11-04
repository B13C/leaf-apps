package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXPermissionsResDto;
import cn.gaple.rbac.entities.GXPermissionsEntity;
import cn.gaple.rbac.mapper.GXPermissionsMapper;
import cn.maple.core.datasource.dao.GXBaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXPermissionsDao extends GXBaseDao<GXPermissionsEntity, GXPermissionsMapper, GXPermissionsResDto> {
}
