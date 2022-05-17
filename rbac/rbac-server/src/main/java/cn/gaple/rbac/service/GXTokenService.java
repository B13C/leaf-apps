package cn.gaple.rbac.service;

import cn.gaple.rbac.dao.GXTokenDao;
import cn.gaple.rbac.dto.req.GXTokenReqDto;
import cn.gaple.rbac.dto.res.GXTokenDBResDto;
import cn.gaple.rbac.entities.GXTokenModel;
import cn.gaple.rbac.mapper.GXTokenMapper;
import cn.gaple.rbac.repository.GXTokenRepository;
import cn.maple.core.datasource.service.GXMyBatisBaseService;

public interface GXTokenService extends GXMyBatisBaseService<GXTokenRepository, GXTokenMapper, GXTokenModel, GXTokenDao, GXTokenDBResDto, Integer> {
    /**
     * 创建或者更新用户token
     *
     * @param reqDto 用户token请求数据
     * @return token数据
     */
    String saveOrUpdate(GXTokenReqDto reqDto);
}
