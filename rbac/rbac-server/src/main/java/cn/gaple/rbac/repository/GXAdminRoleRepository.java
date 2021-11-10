package cn.gaple.rbac.repository;

import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRoleEntity;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.repository.GXBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class GXAdminRoleRepository implements GXBaseRepository<GXAdminRoleEntity, GXAdminRoleResDto> {
    public Set<String> getAdminRoles(Dict condition) {
        return null;
    }

    public void save(GXAdminRoleEntity target) {
    }
}
