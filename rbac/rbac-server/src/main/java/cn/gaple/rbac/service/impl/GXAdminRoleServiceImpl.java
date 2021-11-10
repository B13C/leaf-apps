package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dto.req.GXAdminRoleReqDto;
import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRoleEntity;
import cn.gaple.rbac.repository.GXAdminRoleRepository;
import cn.gaple.rbac.service.GXAdminRoleService;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.impl.GXDBBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GXAdminRoleServiceImpl extends GXDBBaseServiceImpl<GXAdminRoleRepository, GXAdminRoleEntity, GXAdminRoleReqDto, GXAdminRoleResDto> implements GXAdminRoleService {
    @Override
    public Set<String> getAdminRoles(Long adminId) {
        final Dict condition = Dict.create().set("admin_id", adminId);
        return repository.getAdminRoles(condition);
    }

    public long create(GXAdminRoleEntity target, Dict param) {
        repository.save(target);
        return target.getId();
    }
}
