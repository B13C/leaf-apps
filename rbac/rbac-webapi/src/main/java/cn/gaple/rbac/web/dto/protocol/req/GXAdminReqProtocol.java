package cn.gaple.rbac.web.dto.protocol.req;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminReqProtocol extends GXBaseReqProtocol {
    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 预留扩展数据
     */
    private Dict ext;
}
