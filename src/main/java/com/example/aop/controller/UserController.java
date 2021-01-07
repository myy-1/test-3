package com.example.aop.controller;

import com.example.aop.mapper.UserMapper;
import com.example.aop.model.PageRequest;
import com.example.aop.model.User;
import com.example.aop.model.UserRequest;
import com.example.aop.service.UserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Author: 马月月
 * @Date: 2021/1/6 15:38
 * @Description:
 */
@Slf4j
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/findPage")
    public Object finaPage(PageRequest pageRequest) {
        return userService.findPage(pageRequest);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String classpath = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(classpath);
    }
}
