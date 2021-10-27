package cn.gaple.order.dao;

import cn.gaple.order.entity.UserEntity;
import cn.gaple.order.mapper.UserMapper;
import cn.gaple.order.dto.protocol.res.UserResProtocol;
import com.geoxus.core.datasource.dao.GXBaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GXBaseDao<UserMapper, UserEntity> {
    public UserResProtocol getUserInfo(Long userId) {
        return baseMapper.getUserInfo(userId);
    }
}
