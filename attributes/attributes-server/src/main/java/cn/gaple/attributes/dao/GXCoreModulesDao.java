package cn.gaple.attributes.dao;

import cn.gaple.attributes.entity.GXCoreModulesModel;
import cn.gaple.attributes.mapper.GXCoreModulesMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXCoreModulesDao extends GXMyBatisDao<GXCoreModulesMapper, GXCoreModulesModel, Integer> {
}
