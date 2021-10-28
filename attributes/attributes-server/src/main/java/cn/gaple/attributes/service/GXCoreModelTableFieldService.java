package cn.gaple.attributes.service;

import cn.gaple.attributes.dao.GXCoreModelTableFieldDao;
import cn.gaple.attributes.entity.GXCoreModelTableFieldEntity;
import cn.gaple.attributes.mapper.GXCoreModelTableFieldMapper;
import cn.hutool.core.lang.Dict;
import com.geoxus.core.datasource.service.GXDBBaseService;
import com.geoxus.core.datasource.service.GXValidateDBExistsService;
import com.geoxus.core.datasource.service.GXValidateDBUniqueService;

import java.util.List;

public interface GXCoreModelTableFieldService extends GXDBBaseService<GXCoreModelTableFieldEntity, GXCoreModelTableFieldMapper, GXCoreModelTableFieldDao>,
        GXValidateDBExistsService,
        GXValidateDBUniqueService {
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
