package cn.gaple.rbac.dto.req;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.annotation.GXFieldComment;
import cn.maple.core.framework.annotation.GXMergeSingleField;
import cn.maple.core.framework.dto.GXBaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public class GXAdminLoginReqDto extends GXBaseDto {
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    @NotEmpty(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotNull(message = "密码必填")
    @NotEmpty(message = "密码必填")
    private String password;

    @GXFieldComment("扩展数据")
    private Dict ext;

    @GXMergeSingleField(tableName = "s_admin", fieldName = "test_oo")
    private String test;

    @GXMergeSingleField(tableName = "s_admin", fieldName = "l_test")
    private String lTest;

    @Override
    protected void afterRepair() {
        System.out.println("对数据进行第二次修复");
    }

    @Override
    public void customizeProcess() {
        System.out.println("自定义处理");
    }

    @Override
    protected void verify() {
        System.out.println("对数据进行修复");
    }

    @Override
    protected void beforeRepair() {
        System.out.println("对数据进行第一次修复");
    }
}
