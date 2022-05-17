package cn.gaple.attributes.dao;

import cn.gaple.attributes.entity.GXCoreModelAttributesModel;
import cn.gaple.attributes.mapper.GXCoreModelAttributesMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXCoreModelAttributesDao extends GXMyBatisDao<GXCoreModelAttributesMapper, GXCoreModelAttributesModel, Integer> {
}
