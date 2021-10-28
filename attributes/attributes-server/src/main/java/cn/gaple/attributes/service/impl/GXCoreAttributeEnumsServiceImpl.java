package cn.gaple.attributes.service.impl;

import cn.gaple.attributes.dao.GXCoreAttributeEnumsDao;
import cn.gaple.attributes.entity.GXCoreAttributesEntity;
import cn.gaple.attributes.entity.GXCoreAttributesEnumsEntity;
import cn.gaple.attributes.mapper.GXCoreAttributeEnumsMapper;
import cn.gaple.attributes.service.GXCoreAttributeEnumsService;
import cn.gaple.attributes.service.GXCoreAttributesService;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.json.JSONUtil;
import com.geoxus.core.datasource.annotation.GXDataSource;
import com.geoxus.core.datasource.service.impl.GXDBBaseServiceImpl;
import com.geoxus.core.framework.annotation.GXFieldComment;
import com.geoxus.core.framework.constant.GXCommonConstant;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Service
@GXDataSource("framework")
public class GXCoreAttributeEnumsServiceImpl extends GXDBBaseServiceImpl<GXCoreAttributesEnumsEntity, GXCoreAttributeEnumsMapper, GXCoreAttributeEnumsDao> implements GXCoreAttributeEnumsService {
    @GXFieldComment(zhDesc = "字段不存在的提示")
    private static final String FIELD_VALUE_NOT_EXISTS = "{}属性不存在值{}";

    @Resource
    private GXCoreAttributesService coreAttributesService;

    @Override
    @Cacheable(cacheManager = "caffeineCache", value = "FRAMEWORK-CACHE", key = "targetClass + methodName + #coreModelId + #attributeId + #value")
    public boolean isExistsAttributeValue(int attributeId, Object value, int coreModelId) {
        final List<Dict> list = getBaseMapper().getAttributeEnumsByAttributeIdAndCoreModelId(attributeId, coreModelId);
        if (list.isEmpty()) {
            return true;
        }
        for (Dict dict : list) {
            if (dict.getStr("value_enum").equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validateExists(Object value, String field, ConstraintValidatorContext constraintValidatorContext, Dict param) throws UnsupportedOperationException {
        Dict dict = JSONUtil.toBean(JSONUtil.toJsonStr(value), Dict.class);
        String attributeValue = dict.getStr(field);
        if (null != attributeValue) {
            GXCoreAttributesEntity attributesEntity = coreAttributesService.getAttributeByAttributeName(field);
            if (null != attributesEntity) {
                final int coreModelId = param.getInt(GXCommonConstant.CORE_MODEL_PRIMARY_FIELD_NAME);
                boolean exists = isExistsAttributeValue(attributesEntity.getAttributeId(), attributeValue, coreModelId);
                if (!exists) {
                    constraintValidatorContext.buildConstraintViolationWithTemplate(CharSequenceUtil.format(FIELD_VALUE_NOT_EXISTS, field, attributeValue)).addPropertyNode(field).addConstraintViolation();
                }
                return exists;
            }
        }
        return true;
    }
}
