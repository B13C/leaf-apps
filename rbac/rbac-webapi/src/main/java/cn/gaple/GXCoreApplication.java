package cn.gaple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@SpringBootApplication
//@EnableCaching
//@EnableAspectJAutoProxy
public class GXCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(GXCoreApplication.class, args);
    }
}