package cn.gaple;

import com.geoxus.core.framework.annotation.GXEnableLeafFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@GXEnableLeafFramework
@EnableAspectJAutoProxy
public class ExtraAPP {
    public static void main(String[] args) {
        SpringApplication.run(ExtraAPP.class, args);
    }
}
