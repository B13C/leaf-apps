package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXTokenDao;
import cn.gaple.rbac.entities.GXTokenModel;
import cn.gaple.rbac.mapper.GXTokenMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXTokenRepository extends GXMyBatisRepository<GXTokenMapper, GXTokenModel, GXTokenDao, Integer> {
}
