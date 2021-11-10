package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dto.req.GXRolePermissionsReqDto;
import cn.gaple.rbac.dto.res.GXRolePermissionsResDto;
import cn.gaple.rbac.entities.GXRolePermissionsEntity;
import cn.gaple.rbac.repository.GXRolePermissionsRepository;
import cn.gaple.rbac.service.GXRolePermissionsService;
import cn.maple.core.datasource.service.impl.GXDBBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GXRolePermissionsServiceImpl
        extends GXDBBaseServiceImpl<GXRolePermissionsRepository, GXRolePermissionsEntity, GXRolePermissionsReqDto, GXRolePermissionsResDto>
        implements GXRolePermissionsService {
    /**
     * 通过管理员ID获取权限集
     *
     * @param adminId 管理员ID
     * @return 权限集
     */
    @Override
    public Set<String> getPermissionsByAdminId(Long adminId) {
        return repository.getPermissionsByAdminId(adminId);
    }
}
