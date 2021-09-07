package com.cloud.system.config;

import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * aop配置
 * @author haoliuyang
 */
@Aspect
@Slf4j
@Component
@NoArgsConstructor
public class SystemAspect {
    private Gson gson = new Gson();

    /**
     * 申明一个切点
     */
    @Pointcut("execution(public * com.cloud.system.controller.*.*(..))")
    private void controllerAspect() { }

    /**
     * 请求方法前打印内容
     * @param joinPoint 参数
     */
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //打印请求内容
        log.info("===============请求内容===============");
        log.info("请求地址:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature());
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("===============请求内容===============");
    }

    /**
     * 请求方法后打印内容
     * @param o 对象类型参数
     */
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturing(Object o) {
        log.info("--------------返回内容----------------");
        log.info("Response内容:" + gson.toJson(o));
        log.info("--------------返回内容----------------");

    }
}
