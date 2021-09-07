package com.cloud.contactmanger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author haoliuyang
 */
@MapperScan({"com.cloud.contactmanger.mapper"})
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ContactmangerApplication {

    /**
     * 启动类
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(ContactmangerApplication.class, args);
    }

}
