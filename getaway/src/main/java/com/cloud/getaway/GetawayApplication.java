package com.cloud.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author haoliuyang
 */
@EnableEurekaClient
@SpringBootApplication
public class GetawayApplication {

    /**
     * 启动类
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(GetawayApplication.class, args);
    }
}
