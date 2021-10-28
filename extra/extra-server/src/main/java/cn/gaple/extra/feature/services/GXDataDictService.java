package cn.gaple.extra.feature.services;

import cn.gaple.extra.feature.dao.GXDataDictDao;
import cn.gaple.extra.feature.entities.GXDataDictEntity;
import cn.gaple.extra.feature.mappers.GXDataDictMapper;
import com.geoxus.core.datasource.service.GXValidateDBExistsService;
import com.geoxus.core.datasource.service.GXValidateDBUniqueService;

public interface GXDataDictService extends com.geoxus.core.datasource.service.GXDBBaseService<GXDataDictEntity, GXDataDictMapper, GXDataDictDao>,
        GXValidateDBExistsService,
        GXValidateDBUniqueService {
}