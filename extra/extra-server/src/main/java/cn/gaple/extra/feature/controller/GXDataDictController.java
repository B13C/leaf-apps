package cn.gaple.extra.feature.controller;

import cn.gaple.extra.feature.services.GXDataDictService;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.res.GXPaginationResProtocol;
import cn.maple.core.framework.util.GXResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/generate/dict")
public class GXDataDictController {
    @Resource
    private GXDataDictService dataDictService;

    /**
     * 获取所有区域树
     *
     * @return GXResultUtils
     */
    @PostMapping("/list-or-search")
    public GXResultUtils<GXPaginationResProtocol<Dict>> listOrSearchPage(@RequestBody Dict condition) {
        return null;
    }
}