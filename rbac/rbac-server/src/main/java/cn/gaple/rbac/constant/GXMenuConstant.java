package cn.gaple.rbac.constant;

import cn.maple.core.framework.annotation.GXFieldComment;

public class GXMenuConstant {
    @GXFieldComment(zhDesc = "主键ID")
    public static final String PRIMARY_KEY = "id";

    @GXFieldComment(zhDesc = "表名")
    public static final String TABLE_NAME = "s_menu";

    @GXFieldComment(zhDesc = "数据表别名")
    public static final String TABLE_ALIAS_NAME = "menu";

    @GXFieldComment("数据源")
    public static final String DATASOURCE = "permissions";

    protected GXMenuConstant() {
    }
}
