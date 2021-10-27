package cn.gaple.common.service.impl;

import cn.gaple.common.entity.GXCoreAttributesEntity;
import cn.gaple.common.service.GXCoreAttributesService;
import cn.gaple.common.service.GXCoreModelService;
import cn.gaple.common.validator.GXValidateModelMapService;
import cn.hutool.core.lang.Dict;
import com.geoxus.core.framework.exception.GXBusinessException;
import com.geoxus.core.framework.pojo.GXResultCode;
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
            final GXCoreAttributesEntity attributesEntity = coreAttributesService.getAttributeByAttributeName(map.getStr(key));
            final boolean matches = Pattern.matches(attributesEntity.getValidationExpression(), map.get(key).toString());
            if (!matches) {
                throw new GXBusinessException(GXResultCode.PARAMETER_VALIDATION_ERROR);
            }
        }
        return true;
    }
}
