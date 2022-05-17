package cn.gaple.extra.feature.aspect;

import cn.maple.core.framework.constant.GXTokenConstant;
import cn.maple.core.framework.util.GXCurrentRequestContextUtils;
import cn.maple.core.framework.util.GXResultUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class GXUploadFileLegalAspect {
    @Pointcut("@annotation(cn.gaple.extra.feature.annotation.GXUploadFileLegalAnnotation)")
    public void uploadFileLegalPointCut() {
    }

    @Around("uploadFileLegalPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = GXCurrentRequestContextUtils.getHttpServletRequest();
        assert request != null;
        if (null != request.getHeader(GXTokenConstant.ADMIN_TOKEN_NAME) || null != request.getHeader(GXTokenConstant.USER_TOKEN_NAME)) {
            return point.proceed();
        }
        return GXResultUtils.error("AAAA");
    }
}
