package com.example.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 马月月
 * @Date: 2021/1/5 17:07
 * @Description:
 */
@RestController
public class LogWebController {
    /**
     * 测试正常请求
     */
    @GetMapping("/test1/{msg}")
    public String get(@PathVariable String msg){
        return "msg"+msg;
    }

    /**
     * 测试异常请求
     */
    @GetMapping("/test2")
    public String errorGet(@PathVariable String msg){
        //制造一个异常
        Integer.parseInt("aaaa1");
        return msg;
    }
}
