package cn.gaple.extra.feature.services.impl;

import cn.gaple.extra.feature.entities.GXMediaLibraryModel;
import cn.gaple.extra.feature.services.GXMediaLibraryService;
import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONObject;
import cn.maple.core.datasource.annotation.GXDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service(value = "mediaLibraryService")
@GXDataSource("framework")
public class GXMediaLibraryServiceImpl implements GXMediaLibraryService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(Dict dict) {
        final GXMediaLibraryModel entity = dict.toBean(GXMediaLibraryModel.class);
        return entity.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOwner(long targetId, long coreModelId, List<JSONObject> mediaList, Dict condition) {
        return;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GXMediaLibraryModel saveFileInfo(MultipartFile file, Dict param) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByCondition(Dict param) {
        return false;
    }

    @Override
    public List<Dict> getMediaByCondition(Dict param) {
        return Collections.emptyList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOldFile(Dict param) {
        return;
    }
}
