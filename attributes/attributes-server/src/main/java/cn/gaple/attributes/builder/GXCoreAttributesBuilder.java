package cn.gaple.attributes.builder;

import cn.gaple.attributes.constant.GXCoreAttributesConstant;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import cn.maple.core.datasource.builder.GXBaseBuilder;
import org.apache.ibatis.jdbc.SQL;

public class GXCoreAttributesBuilder implements GXBaseBuilder {
    public String listOrSearch(Dict param) {
        final SQL sql = new SQL().SELECT("ca.*").FROM(CharSequenceUtil.format("{} as ca", GXCoreAttributesConstant.TABLE_NAME));
        return sql.toString();
    }

    public String detail(Dict param) {
        final SQL sql = new SQL().SELECT("ca.*").FROM(CharSequenceUtil.format("{} as ca", GXCoreAttributesConstant.TABLE_NAME));
        sql.WHERE(StrUtil.format("attribute_id = {attribute_id}", param));
        return sql.toString();
    }
}
