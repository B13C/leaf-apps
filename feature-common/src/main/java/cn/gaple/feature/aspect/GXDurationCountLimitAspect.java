package cn.gaple.feature.aspect;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.geoxus.core.framework.annotation.GXFieldComment;
import com.geoxus.core.framework.exception.GXBusinessException;
import com.geoxus.core.framework.util.GXBaseCommonUtil;
import com.geoxus.core.framework.util.GXHttpContextUtils;
import cn.gaple.feature.annotation.GXFrequencyLimitAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Aspect
@Component
public class GXDurationCountLimitAspect {
    @GXFieldComment(zhDesc = "缓存前缀")
    private static final String CACHE_KEY_PFEFIX = "duration:count:limit:";

    @Pointcut("@annotation(GXFrequencyLimitAnnotation)")
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
            sceneValue = GXHttpContextUtils.getClientIP();
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
        String phone = GXHttpContextUtils.getHttpParam("phone", String.class);
        final List<String> specialPhone = Convert.convert(new TypeReference<List<String>>() {
        }, Optional.ofNullable(GXBaseCommonUtil.getEnvironmentValue("special.phone", Object.class)).orElse(Collections.emptyList()));
        return StrUtil.isNotBlank(phone) && CollUtil.contains(specialPhone, phone);
    }
}
