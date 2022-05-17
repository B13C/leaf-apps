package cn.gaple.attributes.dao;

import cn.gaple.attributes.entity.GXCoreAttributesModel;
import cn.gaple.attributes.mapper.GXCoreAttributesMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXCoreAttributesDao extends GXMyBatisDao<GXCoreAttributesMapper, GXCoreAttributesModel, Integer> {
}
