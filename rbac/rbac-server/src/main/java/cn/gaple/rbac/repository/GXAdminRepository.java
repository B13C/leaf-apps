package cn.gaple.rbac.repository;

import cn.gaple.rbac.core.constant.GXAdminConstant;
import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapstruct.req.GXAdminReqMapStruct;
import cn.gaple.rbac.mapstruct.res.GXAdminResMapStruct;
import cn.gaple.rbac.presenter.GXAdminPresenter;
import cn.maple.core.datasource.repository.GXBaseRepository;
import cn.maple.core.datasource.util.GXDBCommonUtils;
import cn.maple.core.framework.dto.inner.res.GXPaginationResDto;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.google.common.collect.Table;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class GXAdminRepository implements GXBaseRepository<GXAdminEntity, GXAdminResDto> {
    @Resource
    private GXAdminDao adminDao;

    @Resource
    private GXAdminReqMapStruct adminReqMapStruct;

    @Resource
    private GXAdminResMapStruct adminResMapStruct;

    @Resource
    private GXAdminPresenter adminPresenter;

    /**
     * 保存数据
     *
     * @param entity    需要保存的数据
     * @param condition 附加条件
     * @return ID
     */
    @Override
    public Integer create(GXAdminEntity entity, Table<String, String, Object> condition) {
        boolean b = adminDao.save(entity);
        if (b) {
            return entity.getId();
        }
        return null;
    }

    /**
     * 保存数据
     *
     * @param entity    需要更新的数据
     * @param condition 附加条件
     * @return ID
     */
    @Override
    public Integer update(GXAdminEntity entity, Table<String, String, Object> condition) {
        UpdateWrapper<GXAdminEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq(GXAdminConstant.PRIMARY_KEY, entity.getId());
        boolean b = adminDao.update(entity, updateWrapper);
        if (b) {
            return entity.getId();
        }
        return null;
    }

    /**
     * 保存数据
     *
     * @param entity    需要更新或者保存的数据
     * @param condition 附加条件
     * @return R
     */
    @Override
    public Integer updateOrCreate(GXAdminEntity entity, Table<String, String, Object> condition) {
        boolean b = adminDao.saveOrUpdate(entity);
        if (b) {
            return entity.getId();
        }
        return null;
    }

    /**
     * 根据条件获取所有数据
     *
     * @param columns   需要获取的列
     * @param condition 条件
     * @return 列表
     */
    @Override
    public List<GXAdminResDto> findByCondition(Set<String> columns, Table<String, String, Object> condition) {
        return adminDao.getListByCondition(GXAdminConstant.TABLE_NAME, columns, condition);
    }

    /**
     * 根据条件获取数据
     *
     * @param whereCondition 查询条件
     * @return GXAdminResDto 返回数据
     */
    @Override
    public GXAdminResDto findOneByCondition(Set<String> columns, Table<String, String, Object> whereCondition) {
        return adminDao.getDataByCondition(GXAdminConstant.TABLE_NAME, columns, whereCondition);
    }

    /**
     * 根据条件获取分页数据
     *
     * @param page           当前页
     * @param pageSize       每页大小
     * @param whereCondition 查询条件
     * @param columns        需要的数据列
     * @return 分页对象
     */
    @Override
    public GXPaginationResDto<GXAdminResDto> paginate(Integer page, Integer pageSize, Table<String, String, Object> whereCondition, Set<String> columns) {
        IPage<GXAdminResDto> iPage = adminDao.constructPageObject(page, pageSize);
        List<GXAdminResDto> list = adminDao.getPageByCondition(iPage, GXAdminConstant.TABLE_NAME, columns, whereCondition);
        return GXDBCommonUtils.convertPageToPaginationResDto(iPage, list);
    }

    /**
     * 根据条件删除
     *
     * @param whereCondition 删除条件
     * @return 影响行数
     */
    @Override
    public Integer deleteWhere(Table<String, String, Object> whereCondition) {
        return 0;
    }
}
