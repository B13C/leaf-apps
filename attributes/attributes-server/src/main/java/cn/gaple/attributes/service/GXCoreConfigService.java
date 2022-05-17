package cn.gaple.attributes.service;

public interface GXCoreConfigService {
    <T> T getConfigObject(String key, Class<T> clazz);

    boolean updateValueByParamKey(String cloudStorageConfigKey, String toJsonStr);
}
