package cn.gaple.rbac.core.constant;

public class GXAdminConstant {
    /**
     * 主键ID
     */
    public static final String PRIMARY_KEY = "id";

    /**
     * 表名
     */
    public static final String TABLE_NAME = "s_admin";

    /**
     * 数据表别名
     */
    public static final String TABLE_ALIAS_NAME = "admin";

    /**
     * 数据源
     */
    public static final String DATASOURCE = "permissions";

    /**
     * 超级管理员标识
     */
    public static final Integer ADMINISTRATOR = 1;

    /**
     * 非超级管理员标识
     */
    public static final Integer NON_ADMINISTRATOR = 2;

    protected GXAdminConstant() {
    }
}
