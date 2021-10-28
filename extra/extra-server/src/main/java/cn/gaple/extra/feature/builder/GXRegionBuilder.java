package cn.gaple.extra.feature.builder;

import cn.gaple.extra.feature.constant.GXRegionConstant;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import com.geoxus.core.datasource.builder.GXBaseBuilder;
import com.google.common.base.Joiner;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;

public class GXRegionBuilder implements GXBaseBuilder {
    @Override
    public String getModelIdentificationValue() {
        return GXRegionConstant.MODEL_IDENTIFICATION_VALUE;
    }

    public String areaInfo(Dict param) {
        final ArrayList<Integer> list = new ArrayList<>();
        if (null != param.getInt("province_id")) {
            list.add(param.getInt("province_id"));
        }
        if (null != param.getInt("city_id")) {
            list.add(param.getInt("city_id"));
        }
        if (null != param.getInt("area_id")) {
            list.add(param.getInt("area_id"));
        }
        final SQL sql = new SQL().SELECT("name").FROM(GXRegionConstant.TABLE_NAME).WHERE(CharSequenceUtil.format("id in ({})", Joiner.on(",").join(list)));
        return sql.toString();
    }
}