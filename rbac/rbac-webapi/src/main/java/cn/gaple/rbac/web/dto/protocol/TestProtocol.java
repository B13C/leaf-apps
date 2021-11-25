package cn.gaple.rbac.web.dto.protocol;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TestProtocol extends GXBaseReqProtocol {
    private String username;

    private Dict ext;
}
