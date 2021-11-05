package cn.gaple.rbac.builder;

import cn.gaple.rbac.core.constant.GXAdminRoleConstant;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ReUtil;
import cn.maple.core.datasource.builder.GXBaseBuilder;
import cn.maple.core.datasource.constant.GXBaseBuilderConstant;
import cn.maple.core.framework.constant.GXCommonConstant;
import org.apache.ibatis.jdbc.SQL;

public class GXAdminRoleBuilder implements GXBaseBuilder {
    /**
     * 获取管理员的角色列表
     *
     * @param condition 查询条件
     * @return SQL语句
     */
    public String getAdminRoles(Dict condition) {
        final SQL sql = new SQL().SELECT("role.code").FROM(GXAdminRoleConstant.TABLE_NAME)
                .INNER_JOIN("role ON role.id = admin_role.role_id");
        condition.forEach((column, value1) -> {
            final String value = Convert.toStr(value1);
            String template = "{} " + GXBaseBuilderConstant.STR_EQ;
            if (ReUtil.isMatch(GXCommonConstant.DIGITAL_REGULAR_EXPRESSION, value)) {
                template = "{} " + GXBaseBuilderConstant.NUMBER_EQ;
            }
            sql.WHERE(CharSequenceUtil.format(template, column, value));
        });
        return sql.toString();
    }
}
