package cn.gaple.common.service;

import cn.gaple.common.dao.GXCoreModelAttributesPermissionDao;
import cn.gaple.common.entity.GXCoreModelAttributesPermissionEntity;
import cn.gaple.common.mapper.GXCoreModelAttributesPermissionMapper;
import cn.hutool.core.lang.Dict;
import com.geoxus.core.datasource.service.GXDBBaseService;

public interface GXCoreModelAttributePermissionService extends GXDBBaseService<GXCoreModelAttributesPermissionEntity, GXCoreModelAttributesPermissionMapper, GXCoreModelAttributesPermissionDao> {
    /**
     * 通过核心模型Id获取模型属性的权限
     *
     * @param coreModelId 核心模型ID
     * @param param       参数
     * @return List
     */
    Dict getModelAttributePermissionByCoreModelId(int coreModelId, Dict param);
}
