package cn.gaple.rbac.dto.req;

import cn.gaple.rbac.constant.GXMenuConstant;
import cn.gaple.rbac.dto.inner.GXResourceTypeInnerReqDto;
import cn.gaple.rbac.enums.GXMenuTypeEnum;
import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.annotation.GXValidateExtData;
import cn.maple.core.framework.dto.GXBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class GXMenuReqDto extends GXBaseDto {
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
     * 菜单资源
     */
    private GXResourceTypeInnerReqDto resource;

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
    @GXValidateExtData(tableName = GXMenuConstant.TABLE_NAME)
    private Dict ext;
}
