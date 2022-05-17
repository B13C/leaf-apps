package cn.gaple.extra.feature.builder;

import cn.gaple.extra.feature.constant.GXDataDictConstant;
import cn.hutool.core.lang.Dict;
import cn.maple.core.datasource.builder.GXBaseBuilder;
import org.apache.ibatis.jdbc.SQL;

public class GXDataDictBuilder implements GXBaseBuilder {
    /**
     * 列表
     *
     * @param param 参数
     * @return String
     */
    public String listOrSearch(Dict param) {
        final SQL sql = new SQL().SELECT("*").FROM(GXDataDictConstant.TABLE_NAME);
        return sql.toString();
    }
}
