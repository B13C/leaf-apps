package cn.gaple.rbac.dto.req;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.inner.req.GXBaseReqDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminPermissionsReqDto extends GXBaseReqDto {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 管理员ID
     */
    private Integer adminId;

    /**
     * 权限ID
     */
    private Integer permissionId;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 扩展数据
     */
    private Dict ext;
}
