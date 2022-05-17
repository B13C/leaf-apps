package cn.gaple.rbac.dto.res;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.res.GXBaseDBResDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminDBResDto extends GXBaseDBResDto {
    /**
     * ID
     */
    private Integer id;

    /**
     * 登录用户名
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
     * 真实名字
     */
    private String realName;

    /**
     * 扩展数据
     */
    private Dict ext;
}
