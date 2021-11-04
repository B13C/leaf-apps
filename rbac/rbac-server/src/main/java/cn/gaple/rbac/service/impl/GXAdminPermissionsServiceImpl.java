package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.GXAdminPermissionsDao;
import cn.gaple.rbac.dto.res.GXAdminPermissionsResDto;
import cn.gaple.rbac.entities.GXAdminPermissionsEntity;
import cn.gaple.rbac.mapper.GXAdminPermissionsMapper;
import cn.gaple.rbac.service.GXAdminPermissionsService;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.impl.GXDBBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GXAdminPermissionsServiceImpl extends
        GXDBBaseServiceImpl<GXAdminPermissionsEntity, GXAdminPermissionsMapper, GXAdminPermissionsDao, GXAdminPermissionsResDto>
        implements GXAdminPermissionsService {
    /**
     * 通过管理员ID获取权限集
     *
     * @param adminId 管理员ID
     * @return 权限集
     */
    @Override
    public Set<String> getPermissionsByAdminId(Long adminId) {
        return getBaseMapper().getPermissionsByAdminId(adminId);
    }

    public long create(GXAdminPermissionsEntity target, Dict param) {
        baseDao.save(target);
        return target.getId();
    }
}
