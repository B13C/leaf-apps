package cn.gaple.feature.services;

import cn.gaple.feature.dao.GXRegionDao;
import cn.gaple.feature.entities.GXRegionEntity;
import cn.gaple.feature.mappers.GXRegionMapper;
import cn.hutool.core.lang.Dict;
import com.geoxus.core.datasource.service.GXDBBaseService;

import java.util.List;

public interface GXRegionService extends GXDBBaseService<GXRegionEntity, GXRegionMapper, GXRegionDao> {
    /**
     * 获取所有区域树
     *
     * @return
     */
    List<GXRegionEntity> getRegionTree();

    /**
     * 通过条件获取区域
     *
     * @param param
     * @return
     */
    List<GXRegionEntity> getRegion(Dict param);

    /**
     * 转换名字到拼音
     *
     * @return
     */
    boolean convertNameToPinYin();
}