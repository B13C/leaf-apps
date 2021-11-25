package cn.gaple.properties;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.dto.GXBaseData;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@EqualsAndHashCode(callSuper = true)
@NacosConfigurationProperties(prefix = "light", dataId = "light-type.yml", autoRefreshed = true, groupId = "DEFAULT_GROUP")
public class LightTypeProperties extends GXBaseData {
    private List<LightTypeValueProperties> types;

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class LightTypeValueProperties extends GXBaseData {
        private String id;

        private String name;

        private String code;

        private List<Dict> list;
    }
}
