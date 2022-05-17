package cn.gaple.attributes.dao;

import cn.gaple.attributes.entity.GXCoreModelModel;
import cn.gaple.attributes.mapper.GXCoreModelMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXCoreModelDao extends GXMyBatisDao<GXCoreModelMapper, GXCoreModelModel, Integer> {
}
