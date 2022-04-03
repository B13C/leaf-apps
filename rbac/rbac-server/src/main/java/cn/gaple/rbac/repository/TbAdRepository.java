package cn.gaple.rbac.repository;

import cn.gaple.rbac.dao.TbAdDao;
import cn.gaple.rbac.dto.res.TbAdResDto;
import cn.gaple.rbac.entities.TbAdModel;
import cn.gaple.rbac.mapper.TbAdMapper;
import cn.maple.core.datasource.repository.GXMyBatisRepository;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

import static cn.gaple.rbac.support.TbAdDynamicSQLSupport.tbAdTable;

@Repository
public class TbAdRepository extends GXMyBatisRepository<TbAdMapper, TbAdModel, TbAdDao, TbAdResDto, Integer> {
    public Collection<TbAdResDto> selectMany(Function<Map<String, Object>, TbAdResDto> rowMapper) {
        SelectStatementProvider selectStatement = SqlBuilder.select(tbAdTable.id, tbAdTable.url, tbAdTable.position)
                .from(tbAdTable, "tt")
                .where(tbAdTable.position, SqlBuilder.isEqualTo("web_index_lb"))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return baseDao.getBaseMapper().selectMany(selectStatement, rowMapper);
    }
}
