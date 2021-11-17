package cn.gaple.aggregate.web.service.impl;

import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidatorContext;

@Service
public class MyGXValidateJSONFieldService {
    public boolean validateJsonFieldData(Object o, String tableName, String parentFieldName, String fieldName, ConstraintValidatorContext context) throws UnsupportedOperationException {
        System.out.println(fieldName + " --- Hello");
        return true;
    }
}
