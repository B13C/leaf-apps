package cn.gaple.rbac.dao;

import cn.gaple.rbac.entities.GXAdminModel;
import cn.gaple.rbac.mapper.GXAdminMapper;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.dao.GXMyBatisDao;
import cn.maple.core.framework.constant.GXBuilderConstant;
import cn.maple.core.framework.dto.inner.GXBaseQueryParamInnerDto;
import cn.maple.core.framework.dto.inner.condition.GXConditionStrEQ;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GXAdminDao extends GXMyBatisDao<GXAdminMapper, GXAdminModel, Integer> {
    public void test() {
        GXConditionStrEQ userNameEQ = new GXConditionStrEQ(getTableName(), "username", "AAAA");
        GXBaseQueryParamInnerDto admin = GXBaseQueryParamInnerDto.builder()
                .tableName("s_admin")
                .tableNameAlias("aaaa")
                .condition(List.of(userNameEQ))
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
             /*   .joins(joins)
                .condition(condition)*/
                .build();
        findByCondition(paramInnerDto);
        System.out.println(AA);
    }
}
