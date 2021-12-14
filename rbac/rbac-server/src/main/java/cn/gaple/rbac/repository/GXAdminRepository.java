package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXAdminRepository extends GXMyBatisRepository<GXAdminMapper, GXAdminEntity, GXAdminDao, GXAdminResDto, Integer> {
    public void test() {
        baseDao.test();
    }
}
