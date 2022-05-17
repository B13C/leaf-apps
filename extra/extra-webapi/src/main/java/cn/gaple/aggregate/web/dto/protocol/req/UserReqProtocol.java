package cn.gaple.aggregate.web.dto.protocol.req;

import lombok.Data;

import javax.validation.Valid;

@Data
public class UserReqProtocol {
    private String userName;

    private String password;

    private String author;

    private String subTitle;

    private String ext;

    @Valid
    private UserDetailProtocol userDetail;
}
