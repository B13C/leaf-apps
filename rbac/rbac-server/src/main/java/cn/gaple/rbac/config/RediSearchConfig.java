package cn.gaple.rbac.config;

import com.redis.lettucemod.RedisModulesClient;
import com.redis.lettucemod.api.StatefulRedisModulesConnection;
import io.lettuce.core.RedisURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.CharBuffer;

@Configuration
public class RediSearchConfig {
    @Bean
    public StatefulRedisModulesConnection<String, String> redisModulesClient() {
        RedisURI redisURI = RedisURI.Builder.redis("192.168.56.101", 6379).withPassword(CharBuffer.wrap("britton")).withDatabase(0).build();
        return RedisModulesClient.create(redisURI).connect();
    }
}
