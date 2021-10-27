package cn.gaple.common.service;

import cn.gaple.common.dao.GXCoreModelTableFieldDao;
import cn.gaple.common.entity.GXCoreModelTableFieldEntity;
import cn.gaple.common.mapper.GXCoreModelTableFieldMapper;
import cn.hutool.core.lang.Dict;

import java.util.List;

public interface GXCoreModelTableFieldService extends com.geoxus.core.datasource.service.GXDBBaseService<GXCoreModelTableFieldEntity, GXCoreModelTableFieldMapper, GXCoreModelTableFieldDao>, com.geoxus.core.datasource.service.GXValidateDBExistsService, com.geoxus.core.datasource.service.GXValidateDBUniqueService {
    /**
     * 通过条件获取数据
     *
     * @param condition 分类名字
     * @return List
     */
    GXCoreModelTableFieldEntity getCoreModelDbFieldByCondition(Dict condition);

    /**
     * 通过条件获取数据
     *
     * @param condition 查询条件
     * @return List
     */
    List<Dict> getModelAttributesByModelId(Dict condition);
}
