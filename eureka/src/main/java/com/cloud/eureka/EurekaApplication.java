package com.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author haoliuyang
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    /**
     * 启动类
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
