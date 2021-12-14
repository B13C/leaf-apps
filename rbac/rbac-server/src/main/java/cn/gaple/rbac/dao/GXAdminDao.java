package cn.gaple.rbac.dao;

import cn.gaple.rbac.dto.res.GXAdminResDto;
import cn.gaple.rbac.entities.GXAdminEntity;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.constant.GXBuilderConstant;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import cn.maple.core.framework.dto.inner.GXBaseQueryParamInnerDto;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.stereotype.Component;

@Component
public class GXAdminDao extends GXMyBatisDao<GXAdminMapper, GXAdminEntity, GXAdminResDto, Integer> {
    public void test() {
        HashBasedTable<String, String, Object> ccc = HashBasedTable.create();
        ccc.put("username", GXBuilderConstant.LIKE, "AAAA");
        GXBaseQueryParamInnerDto admin = GXBaseQueryParamInnerDto.builder()
                .tableName("s_admin")
                .tableNameAlias("aaaa")
                .condition(ccc)
                .build();
        findByCondition(admin);
        // left join s_admin admin ON admin.id = xxxx.admin_id and admin.name = "AAAA"
        Table<String, String, Table<String, String, Dict>> joins = HashBasedTable.create();
        HashBasedTable<String, String, Dict> AA = HashBasedTable.create();
        AA.put("subAliasTable", "admin", Dict.create()
                .set("subColumnA", "mainColumnA")
                .set("subColumnB", "mainColumnB")
                .set("subColumnC", "mainColumnC"));
        //kk.put("alias" , "mainTable.columnNameB" , "targetTable.valueB");

        HashBasedTable<String, String, Dict> BB = HashBasedTable.create();
        BB.put("subMm", "admin", Dict.create()
                .set("subColumnA", "mainColumnA")
                .set("subColumnB", "mainColumnB")
                .set("subColumnCC", "mainColumnC"));
        joins.put(GXBuilderConstant.RIGHT_JOIN_TYPE, "d", AA);
        joins.put(GXBuilderConstant.INNER_JOIN_TYPE, "b", BB);
        /** joins.put(GXBuilderConstant.LEFT_JOIN_TYPE, "c", "c.b_id = b.id");*/
        HashBasedTable<String, String, Object> condition = HashBasedTable.create();
        condition.put("b.name", GXBuilderConstant.RIGHT_LIKE, "aaaa");
        condition.put("c.name", GXBuilderConstant.LEFT_LIKE, "bbbbb");
        GXBaseQueryParamInnerDto paramInnerDto = GXBaseQueryParamInnerDto.builder()
                .tableName("a")
                .joins(joins)
                .condition(condition)
                .build();
        findByCondition(paramInnerDto);
        System.out.println(AA);
    }
}
