package cn.gaple.common.constant;

import com.geoxus.core.framework.annotation.GXFieldComment;

public class GXCoreAttributesConstant {
    @GXFieldComment(zhDesc = "主键ID")
    public static final String PRIMARY_KEY = "attribute_id";

    @GXFieldComment(zhDesc = "数据表名")
    public static final String TABLE_NAME = "core_attributes";

    @GXFieldComment(zhDesc = "数据表的别名")
    public static final String TABLE_ALIAS_NAME = "core_attributes";

    @GXFieldComment(zhDesc = "模型的值")
    public static final String MODEL_IDENTIFICATION_VALUE = "core_attributes";

    private GXCoreAttributesConstant() {
    }
}
