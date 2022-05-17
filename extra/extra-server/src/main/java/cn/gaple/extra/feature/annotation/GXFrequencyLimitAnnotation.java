package cn.gaple.extra.feature.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 限制功能在某段时间内只能被请求的次数
 * 比如: 发送短信的方法
 * 在一个小时内同一个IP地址只能发送5次......
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GXFrequencyLimitAnnotation {
    @AliasFor("count")
    int value() default 10;

    @AliasFor("value")
    int count() default 10;

    String key() default "";

    int expire() default 600;

    String scene() default "ip";
}
