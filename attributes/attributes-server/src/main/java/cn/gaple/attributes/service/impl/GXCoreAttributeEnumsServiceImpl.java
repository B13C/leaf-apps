package cn.gaple.attributes.service.impl;

import cn.gaple.attributes.service.GXCoreAttributeEnumsService;
import cn.gaple.attributes.service.GXCoreAttributesService;
import cn.maple.core.datasource.annotation.GXDataSource;
import cn.maple.core.framework.dto.inner.GXValidateExistsDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.ConstraintValidatorContext;

@Service
@GXDataSource("framework")
public class GXCoreAttributeEnumsServiceImpl implements GXCoreAttributeEnumsService {
    private static final String FIELD_VALUE_NOT_EXISTS = "{}属性不存在值{}";

    @Resource
    private GXCoreAttributesService coreAttributesService;

    @Override
    public boolean isExistsAttributeValue(int attributeId, Object value, int coreModelId) {
        return false;
    }

    @Override
    public boolean validateExists(GXValidateExistsDto validateExistsDto, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
