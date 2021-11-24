package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.core.constant.GXAdminConstant;
import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.req.GXAdminLoginReqDto;
import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.mapstruct.req.GXAdminReqMapStruct;
import cn.gaple.rbac.repository.GXAdminRepository;
import cn.gaple.rbac.service.GXAdminService;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.constant.GXBaseBuilderConstant;
import cn.maple.core.datasource.service.impl.GXDBBaseServiceImpl;
import cn.maple.core.framework.annotation.GXManualValidated;
import cn.maple.core.framework.dto.inner.req.GXBaseQueryParamReqDto;
import cn.maple.core.framework.dto.inner.res.GXPaginationResDto;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Objects;

@Service
public class GXAdminServiceImpl extends
        GXDBBaseServiceImpl<GXAdminRepository, GXAdminMapper, GXAdminEntity, GXAdminDao, GXAdminResDto, Integer>
        implements GXAdminService {
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
        return Dict.create();
    }

    /**
     * 管理员登录
     *
     * @param loginReqDto 登录信息
     * @return 管理员token
     */
    @Override
    @GXManualValidated
    public String login(GXAdminLoginReqDto loginReqDto) {
        GXAdminEntity adminEntity = new GXAdminEntity();
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
    public Integer saveOrUpdate(GXAdminReqDto adminReqDto) {
        GXAdminEntity entity = adminReqMapStruct.sourceToTarget(adminReqDto);
        HashBasedTable<String, String, Object> condition = HashBasedTable.create();
        condition.put("username", "=", "'" + adminReqDto.getUsername() + "'");
        repository.checkRecordIsExists(GXAdminConstant.TABLE_NAME, condition);
        Integer integer = repository.updateOrCreate(entity, null);
        return integer;
    }

    /**
     * 分页数据
     *
     * @param queryParamReqDto 分类查询数据
     * @return 分页对象
     */
    @Override
    public GXPaginationResDto<GXAdminResDto> pagination(GXBaseQueryParamReqDto queryParamReqDto) {
        Integer page = queryParamReqDto.getPage();
        Integer pageSize = queryParamReqDto.getPageSize();
        Dict condition = queryParamReqDto.getCondition();
        Table<String, String, Object> queryCondition = HashBasedTable.create();
        if (Objects.nonNull(condition)) {
            queryCondition.put("username", GXBaseBuilderConstant.RIGHT_LIKE, condition.getStr("username"));
        }
        return repository.paginate(page, pageSize, queryCondition, "paginate", CollUtil.newHashSet("*"));
    }
}
