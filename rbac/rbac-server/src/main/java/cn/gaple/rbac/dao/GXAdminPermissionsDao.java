package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXAdminPermissionsResDto;
import cn.gaple.rbac.entities.GXAdminPermissionsEntity;
import cn.gaple.rbac.mapper.GXAdminPermissionsMapper;
import cn.maple.core.datasource.dao.GXBaseDao;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class GXAdminPermissionsDao extends GXBaseDao<GXAdminPermissionsMapper, GXAdminPermissionsEntity, GXAdminPermissionsResDto> {
    /**
     * 通过管理员ID获取权限集
     *
     * @param adminId 管理员ID
     * @return 权限集
     */
    public Set<String> getPermissionsByAdminId(Long adminId) {
        return baseMapper.getPermissionsByAdminId(adminId);
    }
}
