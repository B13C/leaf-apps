package cn.gaple.rbac.core.constant;

import cn.maple.core.framework.annotation.GXFieldComment;

public class GXRoleConstant {
    @GXFieldComment(zhDesc = "主键ID")
    public static final String PRIMARY_KEY = "id";

    @GXFieldComment(zhDesc = "表名")
    public static final String TABLE_NAME = "s_role";

    @GXFieldComment(zhDesc = "数据表别名")
    public static final String TABLE_ALIAS_NAME = "role";

    @GXFieldComment("数据源")
    public static final String DATASOURCE = "permissions";

    private GXRoleConstant() {
    }
}
