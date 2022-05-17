package cn.gaple.attributes.dao;

import cn.gaple.attributes.entity.GXCoreAttributesEnumsModel;
import cn.gaple.attributes.mapper.GXCoreAttributeEnumsMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXCoreAttributeEnumsDao extends GXMyBatisDao<GXCoreAttributeEnumsMapper, GXCoreAttributesEnumsModel, Integer> {
}
