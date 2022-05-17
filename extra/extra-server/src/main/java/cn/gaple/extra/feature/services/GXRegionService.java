package cn.gaple.extra.feature.services;

import cn.gaple.extra.feature.entities.GXRegionModel;
import cn.hutool.core.lang.Dict;

import java.util.List;

public interface GXRegionService {
    /**
     * 获取所有区域树
     *
     * @return
     */
    List<GXRegionModel> getRegionTree();

    /**
     * 通过条件获取区域
     *
     * @param param
     * @return
     */
    List<GXRegionModel> getRegion(Dict param);

    /**
     * 转换名字到拼音
     *
     * @return
     */
    boolean convertNameToPinYin();
}