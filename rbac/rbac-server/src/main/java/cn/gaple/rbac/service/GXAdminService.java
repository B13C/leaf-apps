package cn.gaple.rbac.service;

import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.req.GXAdminLoginReqDto;
import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.repository.GXAdminRepository;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.GXMyBatisBaseService;
import cn.maple.core.framework.dto.req.GXBaseQueryParamReqDto;
import cn.maple.core.framework.dto.res.GXPaginationResDto;

public interface GXAdminService extends GXMyBatisBaseService<GXAdminRepository, GXAdminMapper, GXAdminEntity, GXAdminDao, GXAdminResDto, Integer> {
    /**
     * 获取当前登录管理员的状态
     *
     * @param adminId 管理员ID
     * @return Dict
     */
    Dict getStatus(long adminId);

    /**
     * 管理员登录
     *
     * @param loginReqDto 登录信息
     * @return 管理员token
     */
    String login(GXAdminLoginReqDto loginReqDto);

    /**
     * 保存管理员信息
     *
     * @param adminReqDto 管理员参数
     * @return 管理员ID
     */
    Integer saveOrUpdate(GXAdminReqDto adminReqDto);

    /**
     * 分页数据
     *
     * @param queryParamReqDto 分类查询数据
     * @return 分页对象
     */
    GXPaginationResDto<GXAdminResDto> pagination(GXBaseQueryParamReqDto queryParamReqDto);
}
