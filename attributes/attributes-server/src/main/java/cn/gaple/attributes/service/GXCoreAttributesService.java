package cn.gaple.attributes.service;

import cn.gaple.attributes.dao.GXCoreAttributesDao;
import cn.gaple.attributes.entity.GXCoreAttributesEntity;
import cn.gaple.attributes.mapper.GXCoreAttributesMapper;
import com.geoxus.core.datasource.service.GXDBBaseService;
import com.geoxus.core.datasource.service.GXValidateDBExistsService;
import com.geoxus.core.datasource.service.GXValidateDBUniqueService;

import java.util.List;

public interface GXCoreAttributesService extends GXValidateDBExistsService,
        GXDBBaseService<GXCoreAttributesEntity, GXCoreAttributesMapper, GXCoreAttributesDao>,
        GXValidateDBUniqueService {
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
