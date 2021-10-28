package cn.gaple.extra.feature.controller;

import cn.gaple.extra.feature.services.GXDataDictService;
import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.geoxus.core.framework.dto.protocol.res.GXPaginationProtocol;
import com.geoxus.core.framework.util.GXResultUtil;
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
    public GXResultUtil<GXPaginationProtocol<Dict>> listOrSearchPage(@RequestBody Dict condition) {
        /*final GXPaginationProtocol<Dict> pagination = */
        IPage<Dict> riPage = dataDictService.listOrSearchPage(condition);
        GXPaginationProtocol<Dict> pagination = new GXPaginationProtocol<>(riPage.getRecords(), riPage.getTotal(), riPage.getSize(), riPage.getCurrent());
        return GXResultUtil.ok(pagination);
    }
}