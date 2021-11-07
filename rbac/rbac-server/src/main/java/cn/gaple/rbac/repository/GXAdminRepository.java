package cn.gaple.rbac.repository;

import cn.gaple.rbac.core.constant.GXAdminConstant;
import cn.gaple.rbac.dao.GXAdminDao;
import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.hutool.core.collection.CollUtil;
import cn.maple.core.framework.repository.GXBaseRepository;
import com.google.common.collect.Table;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class GXAdminRepository implements GXBaseRepository {
    /**
     * 管理员DAO
     */
    private GXAdminDao adminDao;

    @Override
    public <R> List<R> all(Set<String> set, Table<String, String, Object> condition) {
        List<GXAdminResDto> list = adminDao.getListByCondition(GXAdminConstant.TABLE_NAME, CollUtil.newHashSet("*"), condition);
        return null;
    }
}
