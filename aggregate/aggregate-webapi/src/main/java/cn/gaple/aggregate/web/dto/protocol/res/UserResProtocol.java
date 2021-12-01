package cn.gaple.aggregate.web.dto.protocol.res;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.res.GXBaseResProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResProtocol extends GXBaseResProtocol {
    private String userName;

    private String password;

    private String author;

    private String subTitle;

    private Dict ext;
}
