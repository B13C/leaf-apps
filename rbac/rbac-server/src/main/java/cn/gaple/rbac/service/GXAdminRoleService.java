package cn.gaple.rbac.service;

import cn.gaple.rbac.dao.GXAdminRoleDao;
import cn.gaple.rbac.dto.res.GXAdminRoleResDto;
import cn.gaple.rbac.entities.GXAdminRoleEntity;
import cn.gaple.rbac.mapper.GXAdminRoleMapper;
import cn.gaple.rbac.repository.GXAdminRoleRepository;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.GXMyBatisBaseService;

import java.util.HashSet;
import java.util.Set;

public interface GXAdminRoleService extends GXMyBatisBaseService<GXAdminRoleRepository, GXAdminRoleMapper, GXAdminRoleEntity, GXAdminRoleDao, GXAdminRoleResDto, Integer> {
    /**
     * 获取当前人的角色列表
     *
     * @param adminId 为NULL是获取当前登录人的
     * @return Dict
     */
    default Set<String> getAdminRoles(Long adminId) {
        return new HashSet<>(0);
    }

    /**
     * 创建数据
     *
     * @param target 目标实体
     * @param param  额外参数
     * @return long
     */
    long create(GXAdminRoleEntity target, Dict param);
}
