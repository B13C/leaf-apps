package cn.gaple.rbac.dao;

import cn.gaple.rbac.entities.GXPermissionsModel;
import cn.gaple.rbac.mapper.GXPermissionsMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Component;

@Component
public class GXPermissionsDao extends GXMyBatisDao<GXPermissionsMapper, GXPermissionsModel, Integer> {
}
