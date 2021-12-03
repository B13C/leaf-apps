package cn.gaple;

import cn.maple.core.framework.annotation.GXEnableLeafFramework;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@GXEnableLeafFramework
@EnableAspectJAutoProxy
@EnableDubbo
public class AggregateAPP {
    public static void main(String[] args) {
        System.setProperty("nacos.logging.default.config.enabled", "false");
        SpringApplication.run(AggregateAPP.class, args);
    }
}
