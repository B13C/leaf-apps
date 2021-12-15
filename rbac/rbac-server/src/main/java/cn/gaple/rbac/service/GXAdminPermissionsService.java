package cn.gaple.rbac.service;

import cn.gaple.rbac.dao.GXAdminPermissionsDao;
import cn.gaple.rbac.dto.res.GXAdminPermissionsResDto;
import cn.gaple.rbac.entities.GXAdminPermissionsModel;
import cn.gaple.rbac.mapper.GXAdminPermissionsMapper;
import cn.gaple.rbac.repository.GXAdminPermissionsRepository;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.GXMyBatisBaseService;

import java.util.Set;

public interface GXAdminPermissionsService extends GXMyBatisBaseService<GXAdminPermissionsRepository, GXAdminPermissionsMapper, GXAdminPermissionsModel, GXAdminPermissionsDao, GXAdminPermissionsResDto, Integer> {
    /**
     * 通过管理员ID获取权限集
     *
     * @param adminId 管理员ID
     * @return 权限集
     */
    Set<String> getPermissionsByAdminId(Long adminId);

    /**
     * 创建数据
     *
     * @param target 目标实体
     * @param param  额外参数
     * @return long
     */
    long create(GXAdminPermissionsModel target, Dict param);
}
