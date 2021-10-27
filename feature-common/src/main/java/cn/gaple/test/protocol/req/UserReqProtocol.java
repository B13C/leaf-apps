package cn.gaple.test.protocol.req;

import lombok.Data;

import javax.validation.Valid;

@Data
public class UserReqProtocol {
    private String userName;

    private String password;

    @Valid
    private UserDetailProtocol userDetail;
}
