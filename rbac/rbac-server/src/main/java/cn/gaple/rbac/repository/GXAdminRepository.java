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

    /**
     * 保存数据
     *
     * @param saveData 需要保存的数据
     * @return R
     */
    @Override
    public Integer create(GXAdminReqDto saveData) {
        return null;
    }

    /**
     * 保存数据
     *
     * @param updateData 需要更新的数据
     * @return R
     */
    @Override
    public Integer update(GXAdminReqDto updateData) {
        return null;
    }

    /**
     * 保存数据
     *
     * @param data 需要更新或者保存的数据
     * @return R
     */
    @Override
    public Integer updateOrCreate(GXAdminReqDto data) {
        return null;
    }

    /**
     * 获取所有数据
     *
     * @param columns   需要获取的列
     * @param condition 条件
     * @return 列表
     */
    @Override
    public List<GXAdminResDto> all(Set<String> columns, Table<String, String, Object> condition) {
        return null;
    }

    /**
     * 获取第一条数据
     *
     * @param columns   需要获取的列
     * @param condition 条件
     * @return 列表
     */
    @Override
    public GXAdminResDto first(Set<String> columns, Table<String, String, Object> condition) {
        return null;
    }

    /**
     * 根据条件获取数据
     *
     * @param whereCondition 查询条件
     * @return R 返回数据
     */
    @Override
    public GXAdminResDto findByCondition(Table<String, String, Object> whereCondition) {
        return null;
    }

    /**
     * 分页数据
     *
     * @param limit   限制条数
     * @param columns 需要的数据列
     * @return 分页对象
     */
    @Override
    public GXPaginationResDto<GXAdminResDto> paginate(Integer limit, Set<String> columns) {
        return null;
    }

    /**
     * 根据条件删除
     *
     * @param whereCondition 删除条件
     * @return 影响行数
     */
    @Override
    public int deleteWhere(Table<String, String, Object> whereCondition) {
        return 0;
    }
}
