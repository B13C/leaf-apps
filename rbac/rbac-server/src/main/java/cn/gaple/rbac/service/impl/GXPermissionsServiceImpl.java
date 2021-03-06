package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.GXPermissionsDao;
import cn.gaple.rbac.dto.res.GXPermissionsDBResDto;
import cn.gaple.rbac.entities.GXPermissionsModel;
import cn.gaple.rbac.mapper.GXPermissionsMapper;
import cn.gaple.rbac.repository.GXPermissionsRepository;
import cn.gaple.rbac.service.GXAdminPermissionsService;
import cn.gaple.rbac.service.GXPermissionsService;
import cn.gaple.rbac.service.GXRolePermissionsService;
import cn.hutool.core.collection.CollUtil;
import cn.maple.core.datasource.service.impl.GXMyBatisBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class GXPermissionsServiceImpl extends GXMyBatisBaseServiceImpl<GXPermissionsRepository, GXPermissionsMapper, GXPermissionsModel, GXPermissionsDao, GXPermissionsDBResDto, Integer> implements GXPermissionsService {
    @Resource
    private GXAdminPermissionsService adminPermissionsService;

    @Resource
    private GXRolePermissionsService rolePermissionsService;

    @Override
    public Set<String> getAdminAllPermissions(Long adminId) {
        Set<String> adminPermissions = adminPermissionsService.getPermissionsByAdminId(adminId);
        Set<String> rolePermissions = rolePermissionsService.getPermissionsByAdminId(adminId);
        final Collection<String> permissions = CollUtil.addAll(adminPermissions, rolePermissions);
        return new HashSet<>(permissions);
    }
}
