package cn.gaple.rbac.web.dto.protocol.res;

import cn.gaple.rbac.web.service.impl.MyGXValidateJSONFieldService;
import cn.maple.core.framework.annotation.GXMergeSingleField;
import cn.maple.core.framework.annotation.GXValidateExtData;
import cn.maple.core.framework.dto.protocol.res.GXBaseResProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResProtocol extends GXBaseResProtocol {
    private String userName;

    private String password;

    @GXMergeSingleField(tableName = "", fieldName = "author", service = MyGXValidateJSONFieldService.class)
    private String author;

    @GXMergeSingleField(tableName = "", fieldName = "sub_title")
    private String subTitle;

    @GXValidateExtData(tableName = "")
    private String ext;
}
