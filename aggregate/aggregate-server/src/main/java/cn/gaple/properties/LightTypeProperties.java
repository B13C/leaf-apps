package cn.gaple.properties;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.GXBaseData;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@EqualsAndHashCode(callSuper = true)
@NacosConfigurationProperties(prefix = "light", dataId = "light-type.yml", autoRefreshed = true)
@NacosPropertySource(dataId = "light-type.yml", autoRefreshed = true, groupId = "DEFAULT_GROUP")
public class LightTypeProperties extends GXBaseData {
    private List<Dict> types;
}
