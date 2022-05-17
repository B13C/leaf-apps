package cn.gaple.extra.feature.dao;

import cn.gaple.extra.feature.entities.GXMediaLibraryModel;
import cn.gaple.extra.feature.mappers.GXMediaLibraryMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXMediaLibraryDao extends GXMyBatisDao<GXMediaLibraryMapper, GXMediaLibraryModel, Integer> {
}
