package cn.gaple.rbac.web.controller.frontend;

import cn.gaple.rbac.web.dto.protocol.req.UserReqProtocol;
import cn.gaple.rbac.web.service.TestService;
import cn.maple.core.framework.util.GXResultUtils;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    private static final String CACHE_NAME = "__DEFAULT__";

    @Resource
    private CaffeineCacheManager caffeineCacheManager;

    @Resource
    private RedissonSpringCacheManager redissonSpringCacheManager;

    @Resource
    private TestService testService;

    @PostMapping("set-cache")
    public GXResultUtils<String> setCache() {
        String key = "key";
        String value = "value";
        UserReqProtocol userReqProtocol = new UserReqProtocol();
        testService.test(userReqProtocol);
        caffeineCacheManager.getCache(CACHE_NAME).put(key, value);
        redissonSpringCacheManager.getCache(CACHE_NAME).put("AAAA", "风之伤AAAAAAAAAAAAAA");
        return GXResultUtils.ok("Hello World");
    }

    @GetMapping("get-cache")
    public GXResultUtils<String> getCache(@RequestParam String key) {
        Cache.ValueWrapper valueWrapper = caffeineCacheManager.getCache(CACHE_NAME).get(key);
        Object o = valueWrapper.get();
        Cache.ValueWrapper valueWrapper1 = redissonSpringCacheManager.getCache(CACHE_NAME).get("AAAA");
        return GXResultUtils.ok("Hello World" + o + ":: " + valueWrapper1.get());
    }
}
