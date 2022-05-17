package cn.gaple.rbac.dao;

import cn.gaple.rbac.entities.GXRolePermissionsModel;
import cn.gaple.rbac.mapper.GXRolePermissionsMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GXRolePermissionsDao extends GXMyBatisDao<GXRolePermissionsMapper, GXRolePermissionsModel, Integer> {
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
