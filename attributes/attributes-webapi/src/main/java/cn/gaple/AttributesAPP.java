package cn.gaple;

import cn.maple.core.framework.annotation.GXEnableLeafFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@GXEnableLeafFramework
@EnableAspectJAutoProxy
public class AttributesAPP {
    public static void main(String[] args) {
        SpringApplication.run(AttributesAPP.class, args);
    }
}
