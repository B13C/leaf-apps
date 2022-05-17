package cn.gaple.attributes.builder;

import cn.gaple.attributes.constant.GXCoreModelConstant;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.builder.GXBaseBuilder;
import org.apache.ibatis.jdbc.SQL;

public class GXCoreModelBuilder implements GXBaseBuilder {
    public String getSearchCondition(Dict param) {
        final SQL sql = new SQL().SELECT("model_id , search_condition").FROM(GXCoreModelConstant.TABLE_NAME);
        boolean whereConditionIsExists = false;
        if (!whereConditionIsExists) {
            sql.WHERE(" 1 = 0");
        }
        return sql.toString();
    }
}
