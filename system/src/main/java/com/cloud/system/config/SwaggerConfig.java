//package com.cloud.system.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @author haoliuyang
// */
//@Configuration
//@EnableSwagger2
//@ConditionalOnProperty(prefix = "mconfig", name = "swagger-ui-open", havingValue = "true")
//public class SwaggerConfig {
//    /**
//     * 创建api
//     *
//     * @return 返回类型Docket
//     */
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * 信息
//     *
//     * @return 返回类型ApiInfo
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("system")
//                .description("systemAPI接口文档")
//                .version("2")
//                .build();
//    }
//}
