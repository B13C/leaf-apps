package cn.gaple.rbac.service.impl;

import cn.gaple.rbac.dao.TbAdDao;
import cn.gaple.rbac.dto.res.TbAdResDto;
import cn.gaple.rbac.entities.TbAdModel;
import cn.gaple.rbac.mapper.TbAdMapper;
import cn.gaple.rbac.repository.TbAdRepository;
import cn.gaple.rbac.service.TbAdService;
import cn.maple.core.datasource.service.impl.GXMyBatisBaseServiceImpl;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static cn.gaple.rbac.support.TbAdDynamicSQLSupport.tbAdTable;

@Service
public class TbAdServiceImpl extends GXMyBatisBaseServiceImpl<TbAdRepository, TbAdMapper, TbAdModel, TbAdDao, TbAdResDto, Integer> implements TbAdService {
    @Override
    public void test() {
        SelectStatementProvider selectStatement = SqlBuilder.select(tbAdTable.id, tbAdTable.url, tbAdTable.position).from(tbAdTable, "tt")
                .where(tbAdTable.position, SqlBuilder.isEqualTo("web_index_lb"))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        Collection<TbAdResDto> selectManyMappedRows = findByCallMethod("selectManyMappedRows", selectStatement);
        System.out.println(selectManyMappedRows);
    }
}
