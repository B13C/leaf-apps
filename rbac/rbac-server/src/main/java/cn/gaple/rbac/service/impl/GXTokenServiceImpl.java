package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.GXTokenDao;
import cn.gaple.rbac.dto.req.GXTokenReqDto;
import cn.gaple.rbac.dto.res.GXTokenDBResDto;
import cn.gaple.rbac.entities.GXTokenModel;
import cn.gaple.rbac.mapper.GXTokenMapper;
import cn.gaple.rbac.mapstruct.req.GXTokenReqMapStruct;
import cn.gaple.rbac.repository.GXTokenRepository;
import cn.gaple.rbac.service.GXTokenService;
import cn.maple.core.datasource.service.impl.GXMyBatisBaseServiceImpl;
import com.google.common.collect.HashBasedTable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GXTokenServiceImpl extends GXMyBatisBaseServiceImpl<GXTokenRepository, GXTokenMapper, GXTokenModel, GXTokenDao, GXTokenDBResDto, Integer> implements GXTokenService {
    @Resource
    private GXTokenReqMapStruct tokenMapStruct;

    /**
     * 创建或者更新用户token
     *
     * @param reqDto 用户token请求数据
     * @return token数据
     */
    @Override
    public String saveOrUpdate(GXTokenReqDto reqDto) {
        GXTokenModel entity = tokenMapStruct.sourceToTarget(reqDto);
        repository.updateOrCreate(entity);
        return null;
    }
}
