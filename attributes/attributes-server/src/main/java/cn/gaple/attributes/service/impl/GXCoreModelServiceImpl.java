package cn.gaple.attributes.service.impl;

import cn.gaple.attributes.entity.GXCoreModelModel;
import cn.gaple.attributes.service.GXCoreModelAttributesService;
import cn.gaple.attributes.service.GXCoreModelService;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import cn.maple.core.datasource.annotation.GXDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
@GXDataSource("framework")
public class GXCoreModelServiceImpl implements GXCoreModelService {
    @Resource
    private GXCoreModelAttributesService coreModelAttributeService;

    @Override
    public GXCoreModelModel getCoreModelByModelId(int modelId, String modelAttributeField) {
        return null;
    }

    @Override
    public boolean checkModelHasAttribute(int modelId, String attributeName) {
        return 1 == coreModelAttributeService.checkCoreModelHasAttribute(modelId, attributeName);
    }

    @Override
    public boolean checkFormKeyMatch(Set<String> keySet, String modelName) {
        final GXCoreModelModel modelEntity = getCoreModelByModelId(getModelIdByModelIdentification(modelName), null);
        if (null == modelEntity) {
            return false;
        }
        final List<Dict> attributes = modelEntity.getCoreAttributes();
        final Set<String> keys = new HashSet<>();
        for (Dict dict : attributes) {
            keys.add(dict.getStr("field_name"));
        }
        return keys.retainAll(keySet);
    }

    @Override
    public Integer getModelIdByModelIdentification(String modelName) {
        return null;
    }

    @Override
    public String getModelTypeByModelId(long coreModelId, String defaultValue) {
        return "Type";
    }

    @Override
    public Dict getSearchCondition(Dict condition) {
        return Dict.create();
    }

    @Override
    public Dict getSearchCondition(Dict condition, String aliasPrefix) {
        final Dict searchFields = getSearchCondition(condition);
        if (CharSequenceUtil.isBlank(aliasPrefix)) {
            return searchFields;
        }
        final Set<Map.Entry<String, Object>> entrySet = searchFields.entrySet();
        final Dict dict = Dict.create();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            final Object value = entry.getValue();
            if (!CharSequenceUtil.contains(key, '.')) {
                key = CharSequenceUtil.format("{}.{}", aliasPrefix, key);
            }
            dict.set(key, value);
        }
        return dict;
    }

    @Override
    public int getCoreModelIdByTableName(String tableName) {
        return 0;
    }
}
