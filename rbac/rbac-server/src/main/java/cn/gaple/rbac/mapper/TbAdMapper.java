package cn.gaple.rbac.mapper;

import cn.gaple.rbac.dto.res.TbAdResDto;
import cn.gaple.rbac.entities.TbAdModel;
import cn.maple.core.datasource.mapper.GXBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbAdMapper extends GXBaseMapper<TbAdModel, TbAdResDto> {
}
