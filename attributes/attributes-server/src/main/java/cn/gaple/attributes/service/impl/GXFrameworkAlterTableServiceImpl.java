package cn.gaple.attributes.service.impl;

import cn.gaple.attributes.service.GXCoreAttributesService;
import cn.gaple.attributes.service.GXCoreModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class GXFrameworkAlterTableServiceImpl {
    @Resource
    private GXCoreAttributesService coreAttributesService;

    @Resource
    private GXCoreModelService coreModelService;

    /**
     * 组合ADD Column SQL语句
     *
     * @param conditionMap 条件
     * @param tableName    表名
     * @param coreModelId  模型ID
     * @return String
     */
    public String generateAddColumnSQL(Map<String, Object> conditionMap, String tableName, int coreModelId) {
        return "";
    }
}
