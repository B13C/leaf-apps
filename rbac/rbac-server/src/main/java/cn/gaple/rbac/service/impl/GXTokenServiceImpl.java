package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.GXTokenDao;
import cn.gaple.rbac.dto.req.GXTokenReqDto;
import cn.gaple.rbac.dto.res.GXTokenResDto;
import cn.gaple.rbac.entities.GXTokenEntity;
import cn.gaple.rbac.mapper.GXTokenMapper;
import cn.gaple.rbac.mapstruct.req.GXTokenReqMapStruct;
import cn.gaple.rbac.service.GXTokenService;
import cn.maple.core.datasource.service.impl.GXDBBaseServiceImpl;
import cn.maple.core.framework.annotation.GXValidated;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GXTokenServiceImpl extends GXDBBaseServiceImpl<GXTokenMapper, GXTokenEntity, GXTokenDao, GXTokenResDto> implements GXTokenService {
    @Resource
    private GXTokenReqMapStruct tokenMapStruct;

    /**
     * 创建或者更新用户token
     *
     * @param reqDto 用户token请求数据
     * @return token数据
     */
    @Override
    public String saveOrUpdate(@GXValidated GXTokenReqDto reqDto) {
        GXTokenEntity entity = tokenMapStruct.sourceToTarget(reqDto);
        baseDao.saveOrUpdateByCondition(entity);
        return null;
    }
}
