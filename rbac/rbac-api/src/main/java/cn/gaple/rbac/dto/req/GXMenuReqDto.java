package cn.gaple.rbac.dto.req;

import cn.gaple.rbac.core.enums.GXMenuTypeEnum;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.inner.req.GXBaseReqDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GXMenuReqDto extends GXBaseReqDto {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 菜单名字
     */
    private String name;

    /**
     * 父级ID
     */
    private String pid;

    /**
     * 按钮类型
     */
    private GXMenuTypeEnum type;

    /**
     * 资源控制器名字
     */
    private String controllerName;

    /**
     * 资源控制器动作名字
     */
    private String actionName;

    /**
     * 资源Code
     */
    private String code;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 扩展预留信息
     */
    private Dict ext;
}
