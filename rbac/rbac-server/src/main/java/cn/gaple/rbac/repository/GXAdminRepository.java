package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.req.GXAdminReqDto;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.mapstruct.req.GXAdminReqMapStruct;
import cn.gaple.rbac.presenter.GXAdminPresenter;
import cn.maple.core.framework.ddd.repository.GXBaseRepository;
import cn.maple.core.framework.dto.inner.res.GXPaginationResDto;
import com.google.common.collect.Table;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class GXAdminRepository implements GXBaseRepository<GXAdminReqDto, GXAdminResDto> {
    @Resource
    private GXAdminDao adminDao;

    @Resource
    private GXAdminReqMapStruct adminReqMapStruct;

    @Resource
    private GXAdminPresenter adminPresenter;

    @Override
    public Integer create(GXAdminReqDto gxAdminReqDto) {
        return null;
    }

    @Override
    public Integer update(GXAdminReqDto gxAdminReqDto) {
        return null;
    }

    @Override
    public Integer updateOrCreate(GXAdminReqDto gxAdminReqDto) {
        return null;
    }

    @Override
    public List<GXAdminResDto> all(Set<String> set, Table<String, String, Object> table) {
        return null;
    }

    @Override
    public GXAdminResDto first(Set<String> set, Table<String, String, Object> table) {
        return null;
    }

    @Override
    public GXAdminResDto findByCondition(Table<String, String, Object> table) {
        return null;
    }

    @Override
    public GXPaginationResDto<GXAdminResDto> paginate(Integer integer, Set<String> set) {
        return null;
    }

    @Override
    public int deleteWhere(Table<String, String, Object> table) {
        return 0;
    }
}
