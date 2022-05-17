package cn.gaple.rbac.dao;

import cn.gaple.rbac.entities.GXAdminPermissionsModel;
import cn.gaple.rbac.mapper.GXAdminPermissionsMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class GXAdminPermissionsDao extends GXMyBatisDao<GXAdminPermissionsMapper, GXAdminPermissionsModel, Integer> {
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
