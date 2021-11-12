package cn.gaple.rbac.web.dto.protocol.req.ext;

import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminExtReqProtocol extends GXBaseReqProtocol {
    @NotNull(message = "作者必填")
    private String author;
}
