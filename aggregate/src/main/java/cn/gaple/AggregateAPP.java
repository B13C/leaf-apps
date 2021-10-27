package cn.gaple;

import com.geoxus.core.framework.annotation.GXEnableLeafFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@GXEnableLeafFramework
public class AggregateAPP {
    public static void main(String[] args) {
        SpringApplication.run(AggregateAPP.class, args);
    }
}