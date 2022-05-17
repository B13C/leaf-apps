package cn.gaple.attributes.dao;

import cn.gaple.attributes.entity.GXCoreModelTableFieldModel;
import cn.gaple.attributes.mapper.GXCoreModelTableFieldMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXCoreModelTableFieldDao extends GXMyBatisDao<GXCoreModelTableFieldMapper, GXCoreModelTableFieldModel, Integer> {
}
