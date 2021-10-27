package cn.gaple.order.dto.protocol.req;

import cn.gaple.order.service.impl.MyGXValidateExtDataService02;
import cn.gaple.order.service.impl.MyGXValidateJsonFieldServiceImpl;
import com.geoxus.core.framework.annotation.GXMergeSingleField;
import com.geoxus.core.framework.annotation.GXValidateExtData;
import com.geoxus.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserReqProtocol extends GXBaseReqProtocol {
    private static final long serialVersionUID = -7741423300357249210L;

    /**
     * 主键ID
     */
    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String address;

    @GXValidateExtData(tableName = "users", service = MyGXValidateExtDataService02.class)
    private String ext;

    @GXMergeSingleField(fieldName = "author", service = MyGXValidateJsonFieldServiceImpl.class)
    private String author;

    @GXMergeSingleField(fieldName = "sub_title", service = MyGXValidateJsonFieldServiceImpl.class)
    private String subTitle;

    @Override
    protected void afterRepair() {
        System.out.println("自定义的修复数据");
        subTitle = "我的副标题哈";
    }
}
