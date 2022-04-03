package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.TbAdDao;
import cn.gaple.rbac.dto.res.TbAdResDto;
import cn.gaple.rbac.entities.TbAdModel;
import cn.gaple.rbac.mapper.TbAdMapper;
import cn.gaple.rbac.repository.TbAdRepository;
import cn.gaple.rbac.service.TbAdService;
import cn.maple.core.datasource.service.impl.GXMyBatisBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Service
public class TbAdServiceImpl extends GXMyBatisBaseServiceImpl<TbAdRepository, TbAdMapper, TbAdModel, TbAdDao, TbAdResDto, Integer> implements TbAdService {
    @Resource
    private TbAdRepository tbAdRepository;

    @Override
    public Collection<TbAdResDto> selectMany(Function<Map<String, Object>, TbAdResDto> rowMapper) {
        return tbAdRepository.find(rowMapper);
    }
}
