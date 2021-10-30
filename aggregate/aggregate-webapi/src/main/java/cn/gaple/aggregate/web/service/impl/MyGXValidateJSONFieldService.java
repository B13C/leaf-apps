package cn.gaple.aggregate.web.service.impl;

import cn.maple.core.framework.validator.GXValidateJSONFieldService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidatorContext;

@Service
public class MyGXValidateJSONFieldService implements GXValidateJSONFieldService {


    @Override
    public boolean validateJsonFieldData(Object o, String tableName, String parentFieldName, String fieldName, ConstraintValidatorContext context) throws UnsupportedOperationException {
        System.out.println(fieldName + " --- Hello");
        return true;
    }
}
