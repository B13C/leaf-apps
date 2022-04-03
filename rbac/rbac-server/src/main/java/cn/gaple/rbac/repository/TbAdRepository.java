package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.TbAdDao;
import cn.gaple.rbac.dto.res.TbAdResDto;
import cn.gaple.rbac.entities.TbAdModel;
import cn.gaple.rbac.mapper.TbAdMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TbAdRepository extends GXMyBatisRepository<TbAdMapper, TbAdModel, TbAdDao, TbAdResDto, Integer> {

}
