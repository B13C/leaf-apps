package cn.gaple.extra.feature.builder;

import cn.gaple.extra.feature.constant.GXMediaLibraryConstant;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import cn.maple.core.datasource.builder.GXBaseBuilder;
import org.apache.ibatis.jdbc.SQL;

@SuppressWarnings("unused")
public class GXMediaLibraryBuilder implements GXBaseBuilder {
    private static final String DB_FIELDS = "id, core_model_id, model_type, target_id, collection_name, name, file_name, size, manipulations, custom_properties, responsive_images, order_column, resource_type";

    public String listOrSearch(Dict param) {
        Long targetId = param.getLong(GXMediaLibraryConstant.TARGET_ID_FIELD_NAME);
        Long coreModelId = param.getLong("core_model_id");
        return new SQL()
                .SELECT("*").FROM(GXMediaLibraryConstant.TABLE_NAME)
                .WHERE(CharSequenceUtil.format("target_id={} and core_model_id={}", targetId, coreModelId))
                .toString();
    }

    public String deleteByCondition(Dict param) {
        Long targetId = param.getLong(GXMediaLibraryConstant.TARGET_ID_FIELD_NAME);
        Long coreModelId = param.getLong("core_model_id");
        final SQL sql = new SQL()
                .DELETE_FROM(GXMediaLibraryConstant.TABLE_NAME)
                .WHERE(CharSequenceUtil.format("target_id = {} and core_model_id = {}", targetId, coreModelId));
        return sql.toString();
    }

    public String detail(Dict param) {
        Long targetId = param.getLong(GXMediaLibraryConstant.TARGET_ID_FIELD_NAME);
        Long coreModelId = param.getLong("core_model_id");
        return new SQL().SELECT("id, model_id, core_model_id, file_name").FROM(GXMediaLibraryConstant.TABLE_NAME)
                .WHERE(CharSequenceUtil.format("target_id={} and core_model_id={}", targetId, coreModelId))
                .toString();
    }

    public String getMediaByCondition(Dict param) {
        final SQL sql = new SQL().SELECT(DB_FIELDS).FROM(GXMediaLibraryConstant.TABLE_NAME);
        if (null != param.getLong(GXMediaLibraryConstant.TARGET_ID_FIELD_NAME)) {
            sql.WHERE(CharSequenceUtil.format("target_id = {}", param.getLong(GXMediaLibraryConstant.TARGET_ID_FIELD_NAME)));
        }
        if (null != param.getLong("core_model_id")) {
            sql.WHERE(CharSequenceUtil.format("core_model_id = {}", param.getLong("core_model_id")));
        }
        if (null != param.getStr("resource_type")) {
            sql.WHERE(CharSequenceUtil.format("resource_type = '{}'", param.getStr("resource_type")));
        }
        if (null != param.getStr("order_by")) {
            sql.ORDER_BY(param.getStr("order_by"));
        }
        if (null != param.getInt("limit")) {
            sql.LIMIT(param.getInt("limit"));
        }
        return sql.toString();
    }
}
