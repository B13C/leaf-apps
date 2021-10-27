package cn.gaple.common.service;

import cn.gaple.common.dao.GXCoreConfigDao;
import cn.gaple.common.entity.GXCoreConfigEntity;
import cn.gaple.common.mapper.GXCoreConfigMapper;
import com.geoxus.core.datasource.service.GXDBBaseService;

public interface GXCoreConfigService extends GXDBBaseService<GXCoreConfigEntity, GXCoreConfigMapper, GXCoreConfigDao> {
    <T> T getConfigObject(String key, Class<T> clazz);

    boolean updateValueByParamKey(String cloudStorageConfigKey, String toJsonStr);
}
