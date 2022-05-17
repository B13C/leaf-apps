package cn.gaple.attributes.service.impl;

import cn.gaple.attributes.entity.GXCoreAttributesModel;
import cn.gaple.attributes.service.GXCoreAttributesService;
import cn.gaple.attributes.service.GXCoreModelService;
import cn.gaple.attributes.validator.GXValidateModelMapService;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.exception.GXBusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class GXValidateModelMapServiceImpl implements GXValidateModelMapService {
    @Resource
    private GXCoreAttributesService coreAttributesService;

    @Resource
    private GXCoreModelService coreModelService;

    @Override
    public boolean validateModelMap(Dict map, String modelName) {
        final Set<String> keySet = map.keySet();
        if (!coreModelService.checkFormKeyMatch(keySet, modelName)) {
            return false;
        }
        for (String key : keySet) {
            final GXCoreAttributesModel attributesEntity = coreAttributesService.getAttributeByAttributeName(map.getStr(key));
            final boolean matches = Pattern.matches(attributesEntity.getValidationExpression(), map.get(key).toString());
            if (!matches) {
                throw new GXBusinessException("AAAA");
            }
        }
        return true;
    }
}
