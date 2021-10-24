package cn.gaple.order.service;

import cn.gaple.core.datasource.service.GXDBBaseService;
import cn.gaple.order.dao.UserDao;
import cn.gaple.order.dto.protocol.req.UserReqProtocol;
import cn.gaple.order.dto.protocol.res.UserResProtocol;
import cn.gaple.order.entity.UserEntity;
import cn.gaple.order.mapper.UserMapper;

public interface UserService extends GXDBBaseService<UserEntity, UserMapper, UserDao> {
    UserResProtocol getUserInfo(Long userId);

    void createOrUpdate(UserReqProtocol userReqProtocol);
}
