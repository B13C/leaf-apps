package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.maple.core.datasource.dao.GXBaseDao;
import org.springframework.stereotype.Component;

@Component
public class GXAdminDao extends GXBaseDao<GXAdminMapper, GXAdminEntity, GXAdminResDto> {
    public Integer saveOrUpdate1(GXAdminEntity entity) {
        saveOrUpdate(entity);
        return 0;
    }
}
