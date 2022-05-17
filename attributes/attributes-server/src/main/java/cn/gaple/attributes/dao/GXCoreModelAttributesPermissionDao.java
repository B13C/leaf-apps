package cn.gaple.attributes.dao;

import cn.gaple.attributes.entity.GXCoreModelAttributesPermissionModel;
import cn.gaple.attributes.mapper.GXCoreModelAttributesPermissionMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXCoreModelAttributesPermissionDao extends GXMyBatisDao<GXCoreModelAttributesPermissionMapper, GXCoreModelAttributesPermissionModel, Integer> {
}
