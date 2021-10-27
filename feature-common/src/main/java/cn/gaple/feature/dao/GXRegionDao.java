package cn.gaple.feature.dao;

import cn.gaple.feature.entities.GXRegionEntity;
import cn.gaple.feature.mappers.GXRegionMapper;
import com.geoxus.core.datasource.dao.GXBaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXRegionDao extends GXBaseDao<GXRegionMapper, GXRegionEntity> {
}
