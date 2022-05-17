package cn.gaple.attributes.validator;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.exception.GXBusinessException;

public interface GXValidateModelMapService {
    boolean validateModelMap(Dict o, String modelName) throws GXBusinessException;
}
