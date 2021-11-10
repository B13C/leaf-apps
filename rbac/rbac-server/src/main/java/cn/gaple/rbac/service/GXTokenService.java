package cn.gaple.rbac.service;

import cn.gaple.rbac.dto.req.GXTokenReqDto;
import cn.gaple.rbac.dto.res.GXTokenResDto;
import cn.gaple.rbac.entities.GXTokenEntity;
import cn.gaple.rbac.repository.GXTokenRepository;
import cn.maple.core.datasource.service.GXDBBaseService;

public interface GXTokenService extends GXDBBaseService<GXTokenRepository, GXTokenEntity, GXTokenReqDto, GXTokenResDto> {
    /**
     * 创建或者更新用户token
     *
     * @param reqDto 用户token请求数据
     * @return token数据
     */
    String saveOrUpdate(GXTokenReqDto reqDto);
}
