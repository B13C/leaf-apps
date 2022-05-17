package cn.gaple.extra.feature.aspect;

import cn.gaple.extra.feature.annotation.GXFrequencyLimitAnnotation;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.maple.core.framework.exception.GXBusinessException;
import cn.maple.core.framework.util.GXCurrentRequestContextUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

@Aspect
@Component
public class GXDurationCountLimitAspect {
    private static final String CACHE_KEY_PFEFIX = "duration:count:limit:";

    @Pointcut("@annotation(cn.gaple.extra.feature.annotation.GXFrequencyLimitAnnotation)")
    public void frequencyLimitPointCut() {
    }

    @Around("frequencyLimitPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        if (passagePhone()) {
            return point.proceed(point.getArgs());
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        final GXFrequencyLimitAnnotation durationCountLimitAnnotation = method.getAnnotation(GXFrequencyLimitAnnotation.class);
        final int count = durationCountLimitAnnotation.count();
        String s = durationCountLimitAnnotation.key();
        if (StrUtil.isBlank(s)) {
            s = RandomUtil.randomString(8);
        }
        String key = CACHE_KEY_PFEFIX.concat(s);
        final int expire = durationCountLimitAnnotation.expire();
        final String scene = durationCountLimitAnnotation.scene();
        String sceneValue = scene;
        if ("ip".equals(scene)) {
            sceneValue = GXCurrentRequestContextUtils.getClientIP();
        }
        key = key.concat(sceneValue);
        //final long actualCount = GXRedisUtils.getCounter(key, expire, TimeUnit.SECONDS);
        final long actualCount = 0;
        if (actualCount > count) {
            throw new GXBusinessException("操作频繁,请稍后在试......");
        }
        return point.proceed(point.getArgs());
    }

    /**
     * 放行指定的电话号码 指定的电话号码不需要次数限制  用于测试使用
     *
     * @return boolean
     */
    private boolean passagePhone() {
        String phone = GXCurrentRequestContextUtils.getHttpParam("phone", String.class);
        final List<String> specialPhone = Collections.emptyList();
        return CharSequenceUtil.isNotBlank(phone) && CollUtil.contains(specialPhone, phone);
    }
}
