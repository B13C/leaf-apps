package cn.gaple.extra.feature.controller;

import cn.gaple.extra.feature.entities.GXRegionModel;
import cn.gaple.extra.feature.services.GXRegionService;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.util.GXResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/generate/region")
public class GXRegionController {
    @Resource
    private GXRegionService regionService;

    /**
     * 获取所有区域树
     *
     * @return GXResultUtils
     */
    @GetMapping("/get-region-tree")
    public GXResultUtils<List<GXRegionModel>> getRegionTree() {
        List<GXRegionModel> list = regionService.getRegionTree();
        return GXResultUtils.ok(list);
    }

    /**
     * 通过条件获取区域
     *
     * @param param
     * @return GXResultUtils
     */
    @PostMapping("/get-region")
    public GXResultUtils<List<GXRegionModel>> getRegion(@RequestBody Dict param) {
        List<GXRegionModel> list = regionService.getRegion(param);
        return GXResultUtils.ok(list);
    }
}