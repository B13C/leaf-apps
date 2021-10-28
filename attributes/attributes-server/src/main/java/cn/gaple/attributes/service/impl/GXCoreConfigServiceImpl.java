package cn.gaple.attributes.service.impl;

import cn.gaple.attributes.constant.GXCoreConfigConstant;
import cn.gaple.attributes.dao.GXCoreConfigDao;
import cn.gaple.attributes.entity.GXCoreConfigEntity;
import cn.gaple.attributes.mapper.GXCoreConfigMapper;
import cn.gaple.attributes.service.GXCoreConfigService;
import cn.hutool.core.lang.Dict;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.geoxus.core.datasource.annotation.GXDataSource;
import com.geoxus.core.datasource.service.impl.GXDBBaseServiceImpl;
import com.geoxus.core.framework.pojo.GXBusinessStatusCode;
import com.geoxus.core.framework.util.GXBaseCommonUtil;
import org.springframework.stereotype.Service;

@Service
@GXDataSource("framework")
public class GXCoreConfigServiceImpl extends GXDBBaseServiceImpl<GXCoreConfigEntity, GXCoreConfigMapper, GXCoreConfigDao> implements GXCoreConfigService {
    public long create(GXCoreConfigEntity target, Dict param) {
        baseDao.save(target);
        return target.getConfigId();
    }

    public long update(GXCoreConfigEntity target, Dict param) {
        baseDao.updateById(target);
        return target.getConfigId();
    }

    public boolean delete(Dict param) {
        final long id = param.getLong(GXCoreConfigConstant.PRIMARY_KEY);
        final GXCoreConfigEntity entity = baseDao.getById(id);
        entity.setStatus(GXBusinessStatusCode.DELETED.getCode());
        baseDao.updateById(entity);
        return false;
    }

    public <R> IPage<R> listOrSearchPage(Dict param, Class<R> clazz) {
        return new Page<>();
    }

    public Dict detail(Dict param) {
        return baseMapper.detail(param);
    }

    @Override
    public <T> T getConfigObject(String key, Class<T> clazz) {
        QueryWrapper<GXCoreConfigEntity> conditionWrapper = new QueryWrapper<GXCoreConfigEntity>().allEq(Dict.create().set("param_key", key));
        GXCoreConfigEntity entity = baseDao.getOne(conditionWrapper);
        if (null != entity) {
            String paramValue = entity.getParamValue();
            if (null != paramValue && JSONUtil.isJson(paramValue)) {
                return JSONUtil.toBean(paramValue, clazz);
            }
        }
        return GXBaseCommonUtil.getClassDefaultValue(clazz);
    }

    @Override
    public boolean updateValueByParamKey(String key, String value) {
        Dict condition = Dict.create().set("param_key", key);
        return updateFieldByCondition(GXCoreConfigEntity.class, Dict.create().set("param_value", value), condition);
    }
}
