package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.core.constant.GXAdminConstant;
import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.req.GXAdminLoginReqDto;
import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.dto.res.GXAdminDBResDto;
import cn.gaple.rbac.entities.GXAdminModel;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.mapstruct.req.GXAdminReqMapStruct;
import cn.gaple.rbac.repository.GXAdminRepository;
import cn.gaple.rbac.service.GXAdminService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.service.impl.GXMyBatisBaseServiceImpl;
import cn.maple.core.framework.dto.inner.GXBaseQueryParamInnerDto;
import cn.maple.core.framework.dto.res.GXPaginationResDto;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashSet;

@Service
public class GXAdminServiceImpl extends GXMyBatisBaseServiceImpl<GXAdminRepository, GXAdminMapper, GXAdminModel, GXAdminDao, GXAdminDBResDto, Integer> implements GXAdminService {
    @Resource
    private GXAdminReqMapStruct adminReqMapStruct;

    @Resource
    private GXAdminRepository adminRepository;

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
        return Dict.create();
    }

    /**
     * 管理员登录
     *
     * @param loginReqDto 登录信息
     * @return 管理员token
     */
    @Override
    public String login(GXAdminLoginReqDto loginReqDto) {
        GXAdminModel adminEntity = new GXAdminModel();
        adminEntity.setExt(Dict.create().set("aaaa", "aaaa"));
        adminEntity.setUsername("aaammm");
        return "";
    }

    /**
     * 保存管理员信息
     *
     * @param adminReqDto 管理员参数
     * @return 管理员ID
     */
    @Override
    public Integer updateOrCreate(GXAdminReqDto adminReqDto) {
        GXAdminModel entity = adminReqMapStruct.sourceToTarget(adminReqDto);
        HashBasedTable<String, String, Object> condition = HashBasedTable.create();
        condition.put("username", "=", "'" + adminReqDto.getUsername() + "'");
        repository.checkRecordIsExists(GXAdminConstant.TABLE_NAME, Collections.emptyList());
        Integer integer = repository.updateOrCreate(entity);
        return integer;
    }

    /**
     * 分页数据
     *
     * @param queryParamReqDto 分类查询数据
     * @return 分页对象
     */
    @Override
    public GXPaginationResDto<GXAdminDBResDto> pagination(GXBaseQueryParamInnerDto queryParamReqDto) {
        Integer page = queryParamReqDto.getPage();
        Integer pageSize = queryParamReqDto.getPageSize();
        Table<String, String, Object> queryCondition = HashBasedTable.create();
        GXPaginationResDto<Dict> paginate = repository.paginate(getTableName(), page, pageSize, Collections.emptyList(), CollUtil.newHashSet("*"));
        return null;
    }

    @Override
    @Cacheable(value = "categoryCache", key = "targetClass + methodName + #p0")
    public GXAdminDBResDto findOneByCondition(GXBaseQueryParamInnerDto searchReqDto) {
        Dict data = adminRepository.findOneByCondition(searchReqDto);
        return convertSourceToTarget(data, GXAdminDBResDto.class, null, null);
    }
}
