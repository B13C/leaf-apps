package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.TbAdDao;
import cn.gaple.rbac.dto.res.TbAdDBResDto;
import cn.gaple.rbac.entities.TbAdModel;
import cn.gaple.rbac.mapper.TbAdMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

@Repository
public class TbAdRepository extends GXMyBatisRepository<TbAdMapper, TbAdModel, TbAdDao, Integer> {
    public Collection<TbAdDBResDto> find(Function<Map<String, Object>, TbAdDBResDto> rowMapper) {
        return null;
    }
}
