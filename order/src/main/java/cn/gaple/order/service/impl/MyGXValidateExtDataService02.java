package cn.gaple.order.service.impl;

import cn.gaple.core.framework.validator.GXValidateExtDataService;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidatorContext;

@Service
public class MyGXValidateExtDataService02  implements GXValidateExtDataService {
    @Override
    public boolean validateExtData(Object o, String modelIdentification, String tableField, boolean isFullMatchAttribute, ConstraintValidatorContext context) throws UnsupportedOperationException {
        System.out.println("Hello XXXXX");
        return false;
    }
}