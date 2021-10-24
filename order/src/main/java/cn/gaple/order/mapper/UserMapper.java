package cn.gaple.order.mapper;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.gaple.core.datasource.mapper.GXBaseMapper;
import cn.gaple.order.builder.UserBuilder;
import cn.gaple.order.dto.protocol.res.UserResProtocol;
import cn.gaple.order.entity.UserEntity;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper extends GXBaseMapper<UserEntity> {
    @SelectProvider(type = UserBuilder.class, method = "getUserInfo")
    @Result(property = "addresses",
            column = "{userId=id,username=username}",
            many = @Many(select = "cn.gaple.order.mapper.AddressMapper.getListByCondition"))
    UserResProtocol getUserInfo(Long userId);

    @SelectProvider(type = UserBuilder.class, method = "listOrSearchPage")
    List<UserResProtocol> listOrSearchPage(IPage<UserResProtocol> page, Dict param);
}
