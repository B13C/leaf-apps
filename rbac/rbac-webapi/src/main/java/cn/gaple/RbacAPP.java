package cn.gaple;

import cn.maple.core.framework.annotation.GXEnableLeafFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@GXEnableLeafFramework
@EnableAspectJAutoProxy
@EnableCaching
//@EnableNacos(globalProperties = @NacosProperties(serverAddr = "${nacos.server-addr:192.168.1.245:8848}"))
public class RbacAPP {
    public static void main(String[] args) {
        System.setProperty("nacos.logging.default.config.enabled", "false");
        SpringApplication.run(RbacAPP.class, args);
    }
}
