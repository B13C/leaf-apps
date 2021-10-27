package cn.gaple.aggregate.dto.protocol.req;

import cn.gaple.aggregate.service.impl.MyGXValidateJSONFieldService;
import com.geoxus.core.framework.annotation.GXMergeSingleField;
import com.geoxus.core.framework.annotation.GXValidateExtData;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class UserReqProtocol {
    private String userName;

    private String password;

    @GXMergeSingleField(tableName = "", fieldName = "author", service = MyGXValidateJSONFieldService.class)
    private String author;

    @GXMergeSingleField(tableName = "", fieldName = "sub_title")
    private String subTitle;

    @GXValidateExtData(tableName = "")
    private String ext;

    @Valid
    private UserDetailProtocol userDetail;
}
