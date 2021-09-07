package com.cloud.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author haoliuyang
 */
@MapperScan({"com.cloud.system.mapper"})
@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
@EnableAspectJAutoProxy
public class SystemApplication {

    /**
     * 启动类
     * @param args 数组参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
