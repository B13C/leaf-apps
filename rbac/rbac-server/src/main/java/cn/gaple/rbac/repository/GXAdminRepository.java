package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.mapstruct.req.GXAdminReqMapStruct;
import cn.gaple.rbac.mapstruct.res.GXAdminResMapStruct;
import cn.gaple.rbac.presenter.GXAdminPresenter;
import cn.maple.core.datasource.repository.GXBaseRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class GXAdminRepository extends GXBaseRepository<GXAdminMapper, GXAdminEntity, GXAdminDao, GXAdminResDto, Integer> {
    public void test() {
        baseDao.test();
    }
}
