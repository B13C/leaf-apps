package cn.gaple.rbac.constant;

import cn.maple.core.framework.annotation.GXFieldComment;

public class GXAdminRoleConstant {
    @GXFieldComment(zhDesc = "主键ID")
    public static final String PRIMARY_KEY = "id";

    @GXFieldComment(zhDesc = "表名")
    public static final String TABLE_NAME = "s_admin_role";

    @GXFieldComment(zhDesc = "数据表别名")
    public static final String TABLE_ALIAS_NAME = "admin_role";

    @GXFieldComment("数据源")
    public static final String DATASOURCE = "permissions";

    private GXAdminRoleConstant() {
    }
}
