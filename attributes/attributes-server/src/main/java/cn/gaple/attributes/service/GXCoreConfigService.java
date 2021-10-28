package cn.gaple.attributes.service;

import cn.gaple.attributes.dao.GXCoreConfigDao;
import cn.gaple.attributes.entity.GXCoreConfigEntity;
import cn.gaple.attributes.mapper.GXCoreConfigMapper;
import com.geoxus.core.datasource.service.GXDBBaseService;

public interface GXCoreConfigService extends GXDBBaseService<GXCoreConfigEntity, GXCoreConfigMapper, GXCoreConfigDao> {
    <T> T getConfigObject(String key, Class<T> clazz);

    boolean updateValueByParamKey(String cloudStorageConfigKey, String toJsonStr);
}
