package cn.gaple.extra.feature.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class GXRecordHistoryAspect {
    @Around("@annotation(cn.gaple.extra.feature.annotation.GXRecordHistoryAnnotation)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        return point.proceed();
    }
}
