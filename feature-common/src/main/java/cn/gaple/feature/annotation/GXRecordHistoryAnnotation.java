package cn.gaple.feature.annotation;

import cn.gaple.common.service.impl.GXCoreModelServiceImpl;
import com.geoxus.core.datasource.service.GXDBBaseService;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GXRecordHistoryAnnotation {
    String originTableName();

    String historyTableName();

    String[] conditionalParameterName() default {};

    Class<? extends GXDBBaseService<?, ?, ?>> service() default GXCoreModelServiceImpl.class;
}
