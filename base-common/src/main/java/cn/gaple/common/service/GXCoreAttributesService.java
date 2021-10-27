package cn.gaple.common.service;

import cn.gaple.common.dao.GXCoreAttributesDao;
import cn.gaple.common.entity.GXCoreAttributesEntity;
import cn.gaple.common.mapper.GXCoreAttributesMapper;
import com.geoxus.core.datasource.service.GXValidateDBExistsService;

import java.util.List;

public interface GXCoreAttributesService extends GXValidateDBExistsService, com.geoxus.core.datasource.service.GXDBBaseService<GXCoreAttributesEntity, GXCoreAttributesMapper, GXCoreAttributesDao>, com.geoxus.core.datasource.service.GXValidateDBUniqueService {
    /**
     * 通过类型获取属性的列表
     *
     * @param category 分类名字
     * @return List
     */
    List<GXCoreAttributesEntity> getAttributesByCategory(String category);

    /**
     * 通过字段名字获取属性
     *
     * @param attributeName 属性名字
     * @return GXCoreAttributesEntity
     */
    GXCoreAttributesEntity getAttributeByAttributeName(String attributeName);

    /**
     * 检测字段是否存在
     * true 存在
     * false 不存在
     *
     * @param attributeName 属性名字
     * @return boolean
     */
    boolean checkFieldIsExists(String attributeName);
}
