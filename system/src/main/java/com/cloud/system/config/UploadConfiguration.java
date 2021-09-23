package com.cloud.system.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * 设置照片回显的虚拟路径
// */
//@Configuration
//public class UploadConfiguration  extends WebMvcConfigurationSupport {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("file:D:\\hly\\ideaProjects\\cloudservice\\system\\src\\main\\resources\\static");
//    }
//}
//

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class UploadConfiguration implements WebMvcConfigurer {

    /**
     * 方法
     * @param registry 参数
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";
        System.out.println(path);


        //配置静态资源访问路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");


//        registry.addResourceHandler("/static/img/**").addResourceLocations("file:" + path);
    }

}
