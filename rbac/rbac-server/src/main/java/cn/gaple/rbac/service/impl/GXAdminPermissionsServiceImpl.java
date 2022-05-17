package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.GXAdminPermissionsDao;
import cn.gaple.rbac.dto.res.GXAdminPermissionsDBResDto;
import cn.gaple.rbac.entities.GXAdminPermissionsModel;
import cn.gaple.rbac.mapper.GXAdminPermissionsMapper;
import cn.gaple.rbac.repository.GXAdminPermissionsRepository;
import cn.gaple.rbac.service.GXAdminPermissionsService;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.impl.GXMyBatisBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GXAdminPermissionsServiceImpl extends GXMyBatisBaseServiceImpl<GXAdminPermissionsRepository, GXAdminPermissionsMapper, GXAdminPermissionsModel, GXAdminPermissionsDao, GXAdminPermissionsDBResDto, Integer> implements GXAdminPermissionsService {
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

    public long create(GXAdminPermissionsModel target, Dict param) {
        repository.save(target);
        return target.getId();
    }
}
