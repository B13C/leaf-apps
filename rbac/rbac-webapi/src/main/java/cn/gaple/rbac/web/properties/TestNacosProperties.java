package cn.gaple.rbac.web.properties;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "user")
@NacosPropertySource(dataId = "test.yml", groupId = "DEFAULT_GROUP", autoRefreshed = true)
public class TestNacosProperties {
    //@NacosValue(value = "my", autoRefreshed = true)
    private String my;
}
