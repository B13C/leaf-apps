package cn.gaple.feature.services;

import cn.gaple.feature.dao.GXDataDictDao;
import cn.gaple.feature.entities.GXDataDictEntity;
import cn.gaple.feature.mappers.GXDataDictMapper;

public interface GXDataDictService extends com.geoxus.core.datasource.service.GXDBBaseService<GXDataDictEntity, GXDataDictMapper, GXDataDictDao>, com.geoxus.core.datasource.service.GXValidateDBExistsService, com.geoxus.core.datasource.service.GXValidateDBUniqueService {
}