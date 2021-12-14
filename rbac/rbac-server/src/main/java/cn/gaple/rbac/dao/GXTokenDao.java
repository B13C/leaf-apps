package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXTokenResDto;
import cn.gaple.rbac.entities.GXTokenEntity;
import cn.gaple.rbac.mapper.GXTokenMapper;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import org.springframework.stereotype.Component;

@Component
public class GXTokenDao extends GXMyBatisDao<GXTokenMapper, GXTokenEntity, GXTokenResDto, Integer> {
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
