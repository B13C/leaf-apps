package cn.gaple.rbac.repository;

import cn.gaple.rbac.dto.res.GXPermissionsResDto;
import cn.gaple.rbac.entities.GXPermissionsEntity;
import cn.maple.core.datasource.repository.GXBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXPermissionsRepository implements GXBaseRepository<GXPermissionsEntity, GXPermissionsResDto> {
}
