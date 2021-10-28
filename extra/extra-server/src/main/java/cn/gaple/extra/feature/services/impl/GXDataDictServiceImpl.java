package cn.gaple.extra.feature.services.impl;

import cn.gaple.extra.feature.dao.GXDataDictDao;
import cn.gaple.extra.feature.entities.GXDataDictEntity;
import cn.gaple.extra.feature.mappers.GXDataDictMapper;
import cn.gaple.extra.feature.services.GXDataDictService;
import com.geoxus.core.datasource.service.GXDBBaseService;
import com.geoxus.core.datasource.service.GXValidateDBExistsService;
import com.geoxus.core.datasource.service.GXValidateDBUniqueService;
import com.geoxus.core.datasource.service.impl.GXDBBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GXDataDictServiceImpl extends GXDBBaseServiceImpl<GXDataDictEntity, GXDataDictMapper, GXDataDictDao> implements GXDataDictService,
        GXValidateDBExistsService,
        GXValidateDBUniqueService,
        GXDBBaseService<GXDataDictEntity, GXDataDictMapper, GXDataDictDao> {
}
