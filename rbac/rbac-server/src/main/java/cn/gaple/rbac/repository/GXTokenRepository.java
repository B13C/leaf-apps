package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXTokenDao;
import cn.gaple.rbac.dto.res.GXTokenResDto;
import cn.gaple.rbac.entities.GXTokenEntity;
import cn.gaple.rbac.mapper.GXTokenMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXTokenRepository extends GXMyBatisRepository<GXTokenMapper, GXTokenEntity, GXTokenDao, GXTokenResDto, Integer> {
}
