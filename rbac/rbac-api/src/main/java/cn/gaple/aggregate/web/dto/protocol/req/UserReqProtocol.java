package cn.gaple.aggregate.web.dto.protocol.req;

import cn.gaple.aggregate.web.service.impl.MyGXValidateJSONFieldService;
import cn.maple.core.framework.annotation.GXMergeSingleField;
import cn.maple.core.framework.annotation.GXValidateExtData;
import cn.maple.core.framework.dto.protocol.req.GXBaseReqProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserReqProtocol extends GXBaseReqProtocol {
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
