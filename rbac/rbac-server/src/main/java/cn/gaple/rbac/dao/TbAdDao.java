package cn.gaple.rbac.dao;

import cn.gaple.rbac.entities.TbAdModel;
import cn.gaple.rbac.mapper.TbAdMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Component;

@Component
public class TbAdDao extends GXMyBatisDao<TbAdMapper, TbAdModel, Integer> {
}
