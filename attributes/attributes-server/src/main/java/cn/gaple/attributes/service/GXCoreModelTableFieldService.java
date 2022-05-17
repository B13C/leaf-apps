package cn.gaple.attributes.service;

import cn.gaple.attributes.entity.GXCoreModelTableFieldModel;
import cn.hutool.core.lang.Dict;

import java.util.List;

public interface GXCoreModelTableFieldService {
    /**
     * 通过条件获取数据
     *
     * @param condition 分类名字
     * @return List
     */
    GXCoreModelTableFieldModel getCoreModelDbFieldByCondition(Dict condition);

    /**
     * 通过条件获取数据
     *
     * @param condition 查询条件
     * @return List
     */
    List<Dict> getModelAttributesByModelId(Dict condition);
}
