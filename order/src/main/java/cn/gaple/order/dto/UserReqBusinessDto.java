package cn.gaple.order.dto;

import cn.gaple.core.framework.dto.GXBaseDto;
import cn.gaple.core.framework.util.GXValidatorUtil;
import cn.gaple.core.framework.validator.group.Group;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserReqBusinessDto extends GXBaseDto {
    private static final long serialVersionUID = -3616191680110988112L;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Length(min = 2000, groups = Group.class)
    private String address;

    @Override
    protected void verify() {
        System.out.println("先自定义验证一下");
        GXValidatorUtil.validateEntity(this, Group.class);
        super.verify();
    }

    @Override
    protected void afterRepair() {
        this.username = "";
        this.address = "";
        this.password = null;
    }
}
