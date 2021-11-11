package cn.gaple;

import cn.maple.core.framework.annotation.GXEnableLeafFramework;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@GXEnableLeafFramework
@EnableAspectJAutoProxy
@EnableNacos(globalProperties = @NacosProperties(serverAddr = "${nacos.server-addr:192.168.1.245:8848}"))
public class RbacAPP {
    public static void main(String[] args) {
        SpringApplication.run(RbacAPP.class, args);
    }
}
