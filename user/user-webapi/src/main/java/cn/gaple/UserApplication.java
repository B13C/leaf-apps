package cn.gaple;

import cn.maple.core.framework.annotation.GXEnableLeafFramework;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@GXEnableLeafFramework
public class UserApplication {
    public static void main(String[] args) {
        System.setProperty("nacos.logging.default.config.enabled", "false");
        SpringApplication.run(UserApplication.class, args);
    }
}
