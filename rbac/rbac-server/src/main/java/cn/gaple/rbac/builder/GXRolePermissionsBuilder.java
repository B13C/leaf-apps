package cn.gaple.rbac.builder;

import cn.hutool.core.text.CharSequenceUtil;
import cn.maple.core.datasource.builder.GXBaseBuilder;
import org.apache.ibatis.jdbc.SQL;

public class GXRolePermissionsBuilder implements GXBaseBuilder {
    /**
     * 通过管理员ID获取权限集
     *
     * @param adminId 管理员ID
     * @return SQL语句
     */
    public String getPermissionsByAdminId(Long adminId) {
        final SQL sql = new SQL().SELECT("permissions.`code`").FROM("permissions")
                .INNER_JOIN("role_permissions ON role_permissions.permission_id = permissions.id")
                .INNER_JOIN(" admin_role ON admin_role.role_id = role_permissions.role_id")
                .WHERE(CharSequenceUtil.format("{}.{} = {}", "admin_role", "admin_id", adminId));
        return sql.toString();
    }
}
