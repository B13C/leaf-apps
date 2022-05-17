package cn.gaple.extra.feature.dao;

import cn.gaple.extra.feature.entities.GXRegionModel;
import cn.gaple.extra.feature.mappers.GXRegionMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXRegionDao extends GXMyBatisDao<GXRegionMapper, GXRegionModel, Integer> {
}
