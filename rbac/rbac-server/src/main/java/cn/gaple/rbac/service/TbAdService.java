package cn.gaple.rbac.service;

import cn.gaple.rbac.dao.TbAdDao;
import cn.gaple.rbac.dto.res.TbAdResDto;
import cn.gaple.rbac.entities.TbAdModel;
import cn.gaple.rbac.mapper.TbAdMapper;
import cn.gaple.rbac.repository.TbAdRepository;
import cn.maple.core.datasource.service.GXMyBatisBaseService;

public interface TbAdService extends GXMyBatisBaseService<TbAdRepository, TbAdMapper, TbAdModel, TbAdDao, TbAdResDto, Integer> {
    void test();
}
