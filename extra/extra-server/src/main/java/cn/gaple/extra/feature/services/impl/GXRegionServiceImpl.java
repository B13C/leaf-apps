package cn.gaple.extra.feature.services.impl;

import cn.gaple.extra.feature.entities.GXRegionModel;
import cn.gaple.extra.feature.services.GXRegionService;
import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GXRegionServiceImpl implements GXRegionService {
    private static final String NAME_TAG = "name";

    private static final String PARENT_TAG = "parent_id";

    private static final String TYPE_TAG = "type";

    @Override
    public List<GXRegionModel> getRegionTree() {
        return Collections.emptyList();
    }

    /**
     * 递归构建
     *
     * @param parent 父级ID
     * @param subs   子集数据
     */
    private void buildSubs(GXRegionModel parent, List<GXRegionModel> subs) {
        List<GXRegionModel> children = subs.stream().filter(sub -> sub.getParentId() == parent.getId()).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(children)) {
            parent.setChildren(children);
            //有子分类的情况 再次递归构建
            children.forEach(child -> buildSubs(child, subs));
        } else {
            parent.setChildren(null);
        }
    }

    @Override
    public List<GXRegionModel> getRegion(Dict param) {
        return Collections.emptyList();
    }

    @Override
    public boolean convertNameToPinYin() {
        return false;
    }
}