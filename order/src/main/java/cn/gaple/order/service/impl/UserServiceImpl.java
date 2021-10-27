package cn.gaple.order.service.impl;

import cn.gaple.order.dao.UserDao;
import cn.gaple.order.dto.protocol.req.UserReqProtocol;
import cn.gaple.order.dto.protocol.res.UserResProtocol;
import cn.gaple.order.entity.UserEntity;
import cn.gaple.order.mapper.UserMapper;
import cn.gaple.order.mapstruct.UserProtocolMapstruct;
import cn.gaple.order.service.UserService;
import com.geoxus.core.datasource.service.GXDBBaseService;
import com.geoxus.core.datasource.service.GXValidateDBExistsService;
import com.geoxus.core.datasource.service.GXValidateDBUniqueService;
import com.geoxus.core.datasource.service.impl.GXDBBaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends GXDBBaseServiceImpl<UserEntity, UserMapper, UserDao> implements
        UserService,
        GXValidateDBExistsService,
        GXValidateDBUniqueService,
        GXDBBaseService<UserEntity, UserMapper, UserDao> {
    @Resource
    private UserProtocolMapstruct userProtocolMapstruct;

    @Override
    public UserResProtocol getUserInfo(Long userId) {
        return baseDao.getUserInfo(userId);
    }

    @Override
    public void createOrUpdate(UserReqProtocol userReqProtocol) {
        UserEntity userEntity = userProtocolMapstruct.sourceToTarget(userReqProtocol);
        baseDao.save(userEntity);
    }
}
