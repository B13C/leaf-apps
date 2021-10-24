package cn.gaple.order.repository.primary;

import cn.gaple.order.entity.UserDto;
import cn.gaple.order.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableMongoRepositories(basePackages = "cn.gaple.order", mongoTemplateRef = "primaryMongoTemplate")
public interface UserRepository extends MongoRepository<UserEntity, String> {
    List<UserDto> findByUsername(String username);

    @Query(value = "{'username':?0}", fields = "{'username':1 , '_id':0}")
    List<UserDto> getListByUsername(String username);
}
