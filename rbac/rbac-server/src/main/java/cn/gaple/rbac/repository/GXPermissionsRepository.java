package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXPermissionsDao;
import cn.gaple.rbac.dto.res.GXPermissionsResDto;
import cn.gaple.rbac.entities.GXPermissionsEntity;
import cn.gaple.rbac.mapper.GXPermissionsMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXPermissionsRepository extends GXMyBatisRepository<GXPermissionsMapper, GXPermissionsEntity, GXPermissionsDao, GXPermissionsResDto, Integer> {
}
