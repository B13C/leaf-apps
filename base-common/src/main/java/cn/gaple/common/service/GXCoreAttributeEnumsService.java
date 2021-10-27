package cn.gaple.common.service;

import cn.gaple.common.dao.GXCoreAttributeEnumsDao;
import cn.gaple.common.entity.GXCoreAttributesEnumsEntity;
import cn.gaple.common.mapper.GXCoreAttributeEnumsMapper;
import com.geoxus.core.datasource.service.GXDBBaseService;
import com.geoxus.core.datasource.service.GXValidateDBExistsService;

public interface GXCoreAttributeEnumsService extends GXDBBaseService<GXCoreAttributesEnumsEntity, GXCoreAttributeEnumsMapper, GXCoreAttributeEnumsDao>, GXValidateDBExistsService {
    /**
     * 检测属性的值是否存在
     *
     * @param attributeId 属性ID
     * @param coreModelId 核心模型ID
     * @param value       　属性值
     * @return　　boolean
     */
    boolean isExistsAttributeValue(int attributeId, Object value, int coreModelId);
}
