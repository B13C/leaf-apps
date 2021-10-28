package cn.gaple.attributes.builder;

import cn.gaple.attributes.constant.GXCoreAttributesConstant;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.geoxus.core.datasource.builder.GXBaseBuilder;
import com.geoxus.core.datasource.constant.GXBaseBuilderConstant;
import org.apache.ibatis.jdbc.SQL;

public class GXCoreAttributesBuilder implements GXBaseBuilder {
    public String listOrSearch(Dict param) {
        final SQL sql = new SQL().SELECT("ca.*").FROM(CharSequenceUtil.format("{} as ca", GXCoreAttributesConstant.TABLE_NAME));
        mergeSearchConditionToSql(sql, param, false);
        return sql.toString();
    }

    public String detail(Dict param) {
        final SQL sql = new SQL().SELECT("ca.*").FROM(CharSequenceUtil.format("{} as ca", GXCoreAttributesConstant.TABLE_NAME));
        sql.WHERE(StrUtil.format("attribute_id = {attribute_id}", param));
        return sql.toString();
    }

    @Override
    public Dict getDefaultSearchField() {
        return Dict.create()
                .set("ca.attributeName", GXBaseBuilderConstant.RIGHT_LIKE)
                .set("ca.showName", GXBaseBuilderConstant.RIGHT_LIKE)
                .set("ca.category", GXBaseBuilderConstant.RIGHT_LIKE);
    }

    @Override
    public String getModelIdentificationValue() {
        return GXCoreAttributesConstant.MODEL_IDENTIFICATION_VALUE;
    }
}
