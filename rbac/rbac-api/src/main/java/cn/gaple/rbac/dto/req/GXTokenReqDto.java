package cn.gaple.rbac.dto.req;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.req.GXBaseReqDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXTokenReqDto extends GXBaseReqDto {
    /**
     * 所属平台(admin、user)
     */
    @NotBlank(message = "平台不能为空")
    private String platform;

    /**
     * 平台的目标ID(user_id、admin_id)
     */
    @NotNull(message = "平台用户ID不能为空")
    private Integer targetId;

    /**
     * 客户端IP
     */
    @NotBlank(message = "客户端IP不能为空")
    private String clientIp;

    /**
     * 预留扩展数据
     */
    private Dict ext;
}
