package cn.gaple.aggregate.dto.protocol.req;

import com.geoxus.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDetailProtocol extends GXBaseReqProtocol {
    @NotEmpty(message = "地址不能为空")
    @NotNull(message = "地址不能为空")
    private String address;
}
