package cn.gaple.rbac.repository;

import cn.gaple.rbac.core.constant.GXAdminConstant;
import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.gaple.rbac.mapstruct.req.GXAdminReqMapStruct;
import cn.gaple.rbac.mapstruct.res.GXAdminResMapStruct;
import cn.gaple.rbac.presenter.GXAdminPresenter;
import cn.maple.core.datasource.repository.GXBaseRepository;
import com.google.common.collect.Table;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class GXAdminRepository extends GXBaseRepository<GXAdminMapper, GXAdminEntity, GXAdminDao, GXAdminResDto, Integer> {
    @Resource
    private GXAdminDao adminDao;

    @Resource
    private GXAdminReqMapStruct adminReqMapStruct;

    @Resource
    private GXAdminResMapStruct adminResMapStruct;

    @Resource
    private GXAdminPresenter adminPresenter;

    /**
     * 根据条件获取所有数据
     *
     * @param columns   需要获取的列
     * @param condition 条件
     * @return 列表
     */
    @Override
    public List<GXAdminResDto> findByCondition(String tableName, Table<String, String, Object> condition, Set<String> columns) {
        return super.findByCondition(GXAdminConstant.TABLE_NAME, condition, columns);
    }

    /**
     * 根据条件获取数据
     *
     * @param condition 查询条件
     * @return GXAdminResDto 返回数据
     */
    @Override
    public GXAdminResDto findOneByCondition(String tableName, Table<String, String, Object> condition, Set<String> columns) {
        return adminDao.findOneByCondition(GXAdminConstant.TABLE_NAME, condition, columns);
    }
}
