package cn.gaple.rbac.constant;

import cn.maple.core.framework.annotation.GXFieldComment;

public class GXRolePermissionsConstant {
    @GXFieldComment(zhDesc = "主键ID")
    public static final String PRIMARY_KEY = "id";

    @GXFieldComment(zhDesc = "表名")
    public static final String TABLE_NAME = "s_role_permissions";

    @GXFieldComment(zhDesc = "数据表别名")
    public static final String TABLE_ALIAS_NAME = "role_permissions";

    @GXFieldComment("数据源")
    public static final String DATASOURCE = "permissions";

    private GXRolePermissionsConstant() {
    }
}
