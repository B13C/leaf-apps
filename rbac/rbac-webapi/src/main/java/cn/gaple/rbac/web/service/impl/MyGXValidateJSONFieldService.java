package cn.gaple.rbac.web.service.impl;

import cn.maple.core.framework.validator.GXValidateJSONFieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidatorContext;

@Service
@Slf4j
public class MyGXValidateJSONFieldService implements GXValidateJSONFieldService {
    @Override
    public boolean validateJsonFieldData(Object o, String tableName, String parentFieldName, String fieldName, ConstraintValidatorContext context) throws UnsupportedOperationException {
        log.info(fieldName + " --- Hello");
        return true;
    }
}
