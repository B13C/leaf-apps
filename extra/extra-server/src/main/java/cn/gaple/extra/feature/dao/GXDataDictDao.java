package cn.gaple.extra.feature.dao;

import cn.gaple.extra.feature.entities.GXDataDictModel;
import cn.gaple.extra.feature.mappers.GXDataDictMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXDataDictDao extends GXMyBatisDao<GXDataDictMapper, GXDataDictModel, Integer> {
}
