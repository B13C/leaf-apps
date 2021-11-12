package cn.gaple.rbac.core.constant;

import cn.maple.core.framework.annotation.GXFieldComment;

public class GXAdminConstant {
    @GXFieldComment(zhDesc = "主键ID")
    public static final String PRIMARY_KEY = "id";

    @GXFieldComment(zhDesc = "表名")
    public static final String TABLE_NAME = "s_admin";

    @GXFieldComment(zhDesc = "数据表别名")
    public static final String TABLE_ALIAS_NAME = "admin";

    @GXFieldComment("数据源")
    public static final String DATASOURCE = "permissions";

    @GXFieldComment("超级管理员标识")
    public static final Integer ADMINISTRATOR = 1;

    @GXFieldComment("非超级管理员标识")
    public static final Integer NON_ADMINISTRATOR = 2;

    protected GXAdminConstant() {
    }
}
