package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXRolePermissionsResDto;
import cn.gaple.rbac.entities.GXRolePermissionsEntity;
import cn.gaple.rbac.mapper.GXRolePermissionsMapper;
import cn.maple.core.datasource.dao.GXBaseDao;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class GXRolePermissionsDao extends GXBaseDao<GXRolePermissionsMapper, GXRolePermissionsEntity, GXRolePermissionsResDto> {
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
