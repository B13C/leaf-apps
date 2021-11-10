package cn.gaple.rbac.repository;

import cn.gaple.rbac.dto.res.GXTokenResDto;
import cn.gaple.rbac.entities.GXTokenEntity;
import cn.maple.core.datasource.repository.GXBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXTokenRepository implements GXBaseRepository<GXTokenEntity, GXTokenResDto> {
}
