package cn.gaple.rbac.service;

import cn.gaple.rbac.dao.GXRolePermissionsDao;
import cn.gaple.rbac.dto.res.GXRolePermissionsResDto;
import cn.gaple.rbac.entities.GXRolePermissionsEntity;
import cn.gaple.rbac.mapper.GXRolePermissionsMapper;
import cn.gaple.rbac.repository.GXRolePermissionsRepository;
import cn.maple.core.datasource.service.GXMyBatisBaseService;

import java.util.Set;

public interface GXRolePermissionsService extends
        GXMyBatisBaseService<GXRolePermissionsRepository, GXRolePermissionsMapper, GXRolePermissionsEntity, GXRolePermissionsDao, GXRolePermissionsResDto, Integer> {
    /**
     * 通过管理员ID获取权限集
     *
     * @param adminId 管理员ID
     * @return 权限集
     */
    Set<String> getPermissionsByAdminId(Long adminId);
}
