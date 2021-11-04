package cn.gaple.rbac.builder;

import cn.hutool.core.text.CharSequenceUtil;
import cn.maple.core.datasource.builder.GXBaseBuilder;
import org.apache.ibatis.jdbc.SQL;

public class GXAdminPermissionsBuilder implements GXBaseBuilder {
    /**
     * 通过管理员ID获取权限集
     *
     * @param adminId 管理员ID
     * @return SQL语句
     */
    public String getPermissionsByAdminId(Long adminId) {
        final SQL sql = new SQL().SELECT("permissions.code").FROM("permissions")
                .INNER_JOIN("admin_permissions ON admin_permissions.permission_id = permissions.id")
                .WHERE(CharSequenceUtil.format("admin_permissions.admin_id = {}", adminId));
        return sql.toString();
    }
}
