package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.GXAdminRoleDao;
import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRoleEntity;
import cn.gaple.rbac.mapper.GXAdminRoleMapper;
import cn.gaple.rbac.repository.GXAdminRoleRepository;
import cn.gaple.rbac.service.GXAdminRoleService;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.impl.GXDBBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class GXAdminRoleServiceImpl extends GXDBBaseServiceImpl<GXAdminRoleRepository, GXAdminRoleMapper, GXAdminRoleEntity, GXAdminRoleDao, GXAdminRoleResDto, Integer>
        implements GXAdminRoleService {
    /**
     * 创建数据
     *
     * @param target 目标实体
     * @param param  额外参数
     * @return long
     */
    @Override
    public long create(GXAdminRoleEntity target, Dict param) {
        return 0;
    }
}
