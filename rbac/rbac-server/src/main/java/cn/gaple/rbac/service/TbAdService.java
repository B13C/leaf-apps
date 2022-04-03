package cn.gaple.rbac.service;

import cn.gaple.rbac.dao.TbAdDao;
import cn.gaple.rbac.dto.res.TbAdResDto;
import cn.gaple.rbac.entities.TbAdModel;
import cn.gaple.rbac.mapper.TbAdMapper;
import cn.gaple.rbac.repository.TbAdRepository;
import cn.maple.core.datasource.service.GXMyBatisBaseService;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public interface TbAdService extends GXMyBatisBaseService<TbAdRepository, TbAdMapper, TbAdModel, TbAdDao, TbAdResDto, Integer> {
    Collection<TbAdResDto> selectMany(Function<Map<String, Object>, TbAdResDto> rowMapper);
}
