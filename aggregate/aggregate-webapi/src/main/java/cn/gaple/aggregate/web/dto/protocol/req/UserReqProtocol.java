package cn.gaple.aggregate.web.dto.protocol.req;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserReqProtocol extends GXBaseReqProtocol {
    private String userName;

    private String password;

    private String author;

    private String subTitle;

    private Dict ext;

    @Valid
    private UserDetailProtocol userDetail;
}
