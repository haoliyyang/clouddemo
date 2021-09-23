package com.cloud.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;

/**
 * @author haoliuyang
 */
@MapperScan({"com.cloud.system.mapper"})
@EnableSwagger2
@EnableFeignClients
@SpringBootApplication
@ComponentScan("com.cloud")
@EnableAspectJAutoProxy
public class SystemApplication {

    /**
     * 启动类
     * @param args 数组参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }

    /**
     * 配置文件存放的路径
     * @return
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("D:\\hly\\ideaProjects\\cloudservice\\system\\src\\main\\resources\\static");
        return factory.createMultipartConfig();
    }
}
