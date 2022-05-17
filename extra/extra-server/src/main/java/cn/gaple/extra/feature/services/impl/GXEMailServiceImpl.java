package cn.gaple.extra.feature.services.impl;

import cn.gaple.extra.feature.services.GXEMailService;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.maple.core.framework.util.GXCacheKeysUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GXEMailServiceImpl implements GXEMailService {
    @Resource
    private GXCacheKeysUtils cacheKeysUtils;

    @Override
    public boolean sendVerifyCode(String email) {
        final String code = RandomUtil.randomString(6);
        final String format = CharSequenceUtil.format("本次修改密码验证码是 : {} , 有效期为5分钟", code);
        final String redisKey = cacheKeysUtils.getCacheKey("sys.email.verify.code", email);
        final String sendResult = MailUtil.send(email, "修改密码验证码", format, false);
        // GXRedisUtils.set(redisKey, code, 300, TimeUnit.SECONDS);
        return CharSequenceUtil.isNotBlank(sendResult);
    }

    @Override
    public boolean verification(String email, String code) {
        final String redisKey = cacheKeysUtils.getCacheKey("sys.email.verify.code", email);
        final String value = "hello";//GXRedisUtils.get(redisKey, String.class);
        if (null != value) {
            return CharSequenceUtil.equalsAnyIgnoreCase(code, value);//GXRedisUtils.delete(redisKey);
        }
        return false;
    }
}
