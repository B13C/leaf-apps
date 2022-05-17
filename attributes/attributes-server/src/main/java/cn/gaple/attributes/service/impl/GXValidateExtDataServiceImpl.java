package cn.gaple.attributes.service.impl;

import cn.gaple.attributes.entity.GXCoreAttributesModel;
import cn.gaple.attributes.service.GXCoreAttributeEnumsService;
import cn.gaple.attributes.service.GXCoreAttributesService;
import cn.gaple.attributes.service.GXCoreModelAttributesService;
import cn.gaple.attributes.service.GXCoreModelService;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import cn.maple.core.datasource.annotation.GXDataSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

@Service
@GXDataSource("framework")
public class GXValidateExtDataServiceImpl {
    private static final int VERIFY_VALUE = 1;

    private static final String FIELD_NOT_EXISTS = "{}模型中的{}属性不存在";

    private static final String FIELD_NOT_MATCH = "{}模型中的{}属性格式错误,需要满足({})的验证条件";

    private static final String FIELD_VALUE_NOT_EXISTS = "{}模型中的{}属性的值{}不存在";

    private static final String MODEL_SETTING_NOT_EXISTS = "{}模型不存在,请先配置模型";

    @Resource
    private GXCoreModelService coreModelService;

    @Resource
    private GXCoreAttributesService coreAttributesService;

    @Resource
    private GXCoreAttributeEnumsService coreAttributeEnumsService;

    @Resource
    private GXCoreModelAttributesService coreModelAttributeService;

    /**
     * 数据验证
     *
     * @param modelIdentification         模型标识
     * @param coreModelId                 模型ID
     * @param parentAttributeValidateRule attribute原始的验证规则
     * @param validateDataMap             需要验证的数据
     * @param context                     验证组件上下文对象
     * @return boolean
     */
    private boolean dataValidation(String modelIdentification, int coreModelId, Dict parentAttributeValidateRule, Map<String, Object> validateDataMap, ConstraintValidatorContext context, int currentIndex) {
        final Set<String> keySet = validateDataMap.keySet();
        for (String attributeName : keySet) {
            final boolean b = coreModelService.checkModelHasAttribute(coreModelId, CharSequenceUtil.toUnderlineCase(attributeName));
            final String errorInfo = currentIndex > -1 ? currentIndex + "." + attributeName : attributeName;
            if (!b) {
                context.buildConstraintViolationWithTemplate(CharSequenceUtil.format(FIELD_NOT_EXISTS, modelIdentification, attributeName)).addPropertyNode(errorInfo).addConstraintViolation();
                return true;
            }
            final GXCoreAttributesModel attribute = coreAttributesService.getAttributeByAttributeName(attributeName);
            Dict modelAttributesData = coreModelAttributeService.getModelAttributeByModelIdAndAttributeId(coreModelId, attribute.getAttributeId());
            String currentRule = modelAttributesData.getStr("validationExpression");
            if (CharSequenceUtil.isBlank(currentRule)) {
                currentRule = Convert.toStr(parentAttributeValidateRule.get(attributeName));
            }
            if (CharSequenceUtil.isBlank(currentRule) && modelAttributesData.getInt("forceValidation") == 0) {
                // 不验证当前数据
                return false;
            }
            final String value = Convert.toStr(validateDataMap.get(attributeName));
            final boolean isMatch = Pattern.matches(currentRule, value);
            if (!isMatch && modelAttributesData.getInt("required") == VERIFY_VALUE) {
                context.buildConstraintViolationWithTemplate(CharSequenceUtil.format(FIELD_NOT_MATCH, modelIdentification, attributeName, currentRule)).addPropertyNode(errorInfo).addConstraintViolation();
                return true;
            }
            if (!coreAttributeEnumsService.isExistsAttributeValue(attribute.getAttributeId(), value, coreModelId)) {
                context.buildConstraintViolationWithTemplate(CharSequenceUtil.format(FIELD_VALUE_NOT_EXISTS, modelIdentification, attributeName, value)).addPropertyNode(attributeName).addConstraintViolation();
                return true;
            }
        }
        return false;
    }
}
