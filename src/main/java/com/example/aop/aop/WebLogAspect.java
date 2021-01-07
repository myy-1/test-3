package com.example.aop.aop;

import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Author: 马月月
 * @Date: 2021/1/5 16:45
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    public WebLogAspect(){}

    /**
     * 定义请求日志切点，指定路径
     */
    @Pointcut("execution(public * com.example.aop.controller.*.*(..))")
    public void webLogPointcut(){}

    /**
     * 前置通知
     */
    @Before("webLogPointcut()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //打印请求的内容
        log.info("请求url:"+request.getRequestURI().toString());
        log.info("请求方式："+request.getMethod());
        log.info("请求方法："+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }
    /**
     * 返回通知
     */
    @AfterReturning(returning="ret",pointcut = "webLogPointcut()")
    public void doAfter(Object ret) throws  Throwable{
        //请求返回
        log.info("请求返回：{}"+ret);
    }
    /**
     * 异常通知：
     * 1. 在目标方法非正常结束，发生异常或者抛出异常时执行
     * 1. 在异常通知中设置异常信息，并将其保存
     *
     * @param throwable
     */
    @AfterThrowing(value = "webLogPointcut()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        // 保存异常日志记录
        log.error("发生异常时间：{}" + LocalDateTime.now());
        log.error("抛出异常：{}" + throwable.getMessage());
    }
}
