package cn.gaple.extra.feature.aspect;

import cn.gaple.extra.feature.services.GXCaptchaService;
import cn.gaple.extra.feature.services.GXSendSMSService;
import cn.maple.core.framework.util.GXSpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class GXCheckCaptchaAspect {
    @Pointcut("@annotation(cn.gaple.extra.feature.annotation.GXCheckCaptchaAnnotation)")
    public void checkCaptchaPointCut() {
    }

    @Around("checkCaptchaPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        return point.proceed(point.getArgs());
    }

    private GXSendSMSService getSendSMSService() {
        return GXSpringContextUtils.getBean(GXSendSMSService.class);
    }

    private GXCaptchaService getCaptchaService() {
        return GXSpringContextUtils.getBean(GXCaptchaService.class);
    }
}
