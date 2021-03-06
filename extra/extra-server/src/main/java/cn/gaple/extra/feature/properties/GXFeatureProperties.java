package cn.gaple.extra.feature.properties;

import cn.gaple.extra.feature.interceptor.GXCustomMultipartResolver;
import cn.maple.core.framework.factory.GXYamlPropertySourceFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartResolver;

@Configuration
@PropertySource(value = "classpath:/${spring.profiles.active}/common.yml",
        factory = GXYamlPropertySourceFactory.class,
        ignoreResourceNotFound = true)
public class GXFeatureProperties {
    @Bean
    @ConditionalOnExpression("'${enable-fileupload-progress}'.equals('true')")
    public MultipartResolver multipartResolver() {
        return new GXCustomMultipartResolver();
    }
}
