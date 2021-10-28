package cn.gaple.user.cache.impl;

/*@Slf4j
@Component*/
public class GXSSOCacheRedissonImpl { /*implements GXSSOCache {
    @Resource
    private RedissonClient redissonClient;

    @Override
    public GXSSOToken get(String key, int expires) {
        Object o = redissonClient.getMap(key + "_map").get(key);
        return Convert.convert(GXSSOToken.class, o);
    }

    @Override
    public boolean set(String key, GXSSOToken ssoToken, int expires) {
        redissonClient.getMap(key + "_map").put(key, ssoToken);
        return false;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }*/
}
