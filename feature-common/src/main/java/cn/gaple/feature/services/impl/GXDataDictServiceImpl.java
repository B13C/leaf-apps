package cn.gaple.feature.services.impl;

import cn.gaple.feature.dao.GXDataDictDao;
import cn.gaple.feature.entities.GXDataDictEntity;
import cn.gaple.feature.mappers.GXDataDictMapper;
import cn.gaple.feature.services.GXDataDictService;
import org.springframework.stereotype.Service;

@Service
public class GXDataDictServiceImpl extends com.geoxus.core.datasource.service.impl.GXDBBaseServiceImpl<GXDataDictEntity, GXDataDictMapper, GXDataDictDao> implements GXDataDictService, com.geoxus.core.datasource.service.GXValidateDBExistsService, com.geoxus.core.datasource.service.GXValidateDBUniqueService, com.geoxus.core.datasource.service.GXDBBaseService<GXDataDictEntity, GXDataDictMapper, GXDataDictDao> {
}
