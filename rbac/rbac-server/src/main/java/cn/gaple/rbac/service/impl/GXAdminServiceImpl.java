package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.req.GXAdminLoginReqDto;
import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.mapstruct.req.GXAdminReqMapStruct;
import cn.gaple.rbac.service.GXAdminService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Dict;
import cn.hutool.crypto.SecureUtil;
import cn.maple.core.datasource.service.impl.GXDBBaseServiceImpl;
import cn.maple.core.framework.annotation.GXValidated;
import cn.maple.core.framework.constant.GXTokenConstant;
import cn.maple.core.framework.exception.GXBusinessException;
import cn.maple.core.framework.util.GXTokenManagerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;

@Service
public class GXAdminServiceImpl extends GXDBBaseServiceImpl<GXAdminMapper, GXAdminEntity, GXAdminDao, GXAdminResDto> implements GXAdminService {
    @Resource
    private GXAdminReqMapStruct adminReqMapStruct;

    /**
     * 获取当前登录管理员的状态
     *
     * @param adminId 管理员ID
     * @return Dict
     */
    @Override
    public Dict getStatus(long adminId) {
        final HashSet<String> column = CollUtil.newHashSet("id", "status", "username", "phone", "super_admin");
        final Dict condition = Dict.create().set("id", adminId);
        final Dict data = getFieldValueBySQL(GXAdminEntity.class, column, condition, false);
        if (data.size() == 0) {
            return null;
        }
        data.set(GXTokenConstant.ADMIN_ID, adminId);
        return data;
    }

    /**
     * 管理员登录
     *
     * @param loginReqDto 登录信息
     * @return 管理员token
     */
    @Override
    @GXValidated
    public String login(GXAdminLoginReqDto loginReqDto) {
        GXAdminEntity adminEntity = new GXAdminEntity();
        adminEntity.setExt(Dict.create().set("aaaa", "aaaa"));
        adminEntity.setUsername("aaammm");
        baseDao.saveOrUpdate(adminEntity);
        System.out.println("aaaa : " + adminEntity.getId());
        final String username = loginReqDto.getUsername();
        final String password = loginReqDto.getPassword();
        String secretPassword = SecureUtil.md5(password);
        final Dict condition = Dict.create()
                .set("username", username)
                .set("password", secretPassword);
        final HashSet<String> column = CollUtil.newHashSet("id", "phone", "status");
        final Dict data = getFieldValueBySQL(GXAdminEntity.class, column, condition, false);
        if (data.size() == 0) {
            throw new GXBusinessException("登录信息不存在,请核对之后重试!!");
        }
        final Long adminId = Convert.toLong(data.remove("id"));
        return GXTokenManagerUtils.generateAdminToken(adminId, data);
    }

    /**
     * 保存管理员信息
     *
     * @param adminReqDto 管理员参数
     * @return 管理员ID
     */
    @Override
    public Integer saveOrUpdate(GXAdminReqDto adminReqDto) {
        GXAdminEntity entity = adminReqMapStruct.sourceToTarget(adminReqDto);
        int b = baseDao.saveOrUpdate1(entity);
        return -1;
    }
}
