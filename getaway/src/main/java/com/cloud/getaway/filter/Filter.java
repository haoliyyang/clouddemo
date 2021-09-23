//package com.cloud.getaway.filter;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//
///**
// * 全局过滤器检验请求中是否携带uuid
// * @author haoliuyang
// */
//@Component
//public class Filter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
////        获取请求
//        ServerHttpRequest request = exchange.getRequest();
////        获取响应
//        ServerHttpResponse response = exchange.getResponse();
////        获取请求头
//        HttpHeaders header = request.getHeaders();
////        获取请求url
//        String url = request.getURI().toString();
////        不拦截测试
//        if (url.contains("hello")) {
//            return chain.filter(exchange);
//        }
////        获取header中数据
//        String uuid = header.getFirst("uuid");
//
//        if (StringUtils.isEmpty(uuid)) {
//           return response.setComplete();
//        }
//
//        return chain.filter(exchange);
//    }
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
