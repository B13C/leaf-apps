package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.entities.GXAdminModel;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GXAdminRepository extends GXMyBatisRepository<GXAdminMapper, GXAdminModel, GXAdminDao, Integer> {
    public void test() {
        baseDao.test();
    }
}
