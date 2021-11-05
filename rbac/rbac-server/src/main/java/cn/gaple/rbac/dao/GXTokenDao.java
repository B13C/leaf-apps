package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXTokenResDto;
import cn.gaple.rbac.entities.GXTokenEntity;
import cn.gaple.rbac.mapper.GXTokenMapper;
import cn.maple.core.datasource.dao.GXBaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class GXTokenDao extends GXBaseDao<GXTokenMapper, GXTokenEntity, GXTokenResDto> {
    /**
     * 更具条件更新数据
     *
     * @param entity 实体数据
     * @return 更新是否成功
     */
    public boolean saveOrUpdateByCondition(GXTokenEntity entity) {
        String clientIp = entity.getClientIp();
        Integer targetId = entity.getTargetId();
        String platform = entity.getPlatform();
        return saveOrUpdate(entity);
    }
}
