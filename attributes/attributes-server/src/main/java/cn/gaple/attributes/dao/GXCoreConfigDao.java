package cn.gaple.attributes.dao;

import cn.gaple.attributes.entity.GXCoreConfigModel;
import cn.gaple.attributes.mapper.GXCoreConfigMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXCoreConfigDao extends GXMyBatisDao<GXCoreConfigMapper, GXCoreConfigModel, Integer> {
}
