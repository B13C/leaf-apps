package cn.gaple.rbac.dto.req.ext;

import cn.maple.core.framework.dto.inner.req.GXBaseReqDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminExtReqDto extends GXBaseReqDto {
    /**
     * 作者
     */
    @NotNull(message = "作者信息必填")
    private String author;

    @NotNull(message = "地址信息必填")
    private String address;
}
