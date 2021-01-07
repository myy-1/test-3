package com.example.aop;

import com.example.aop.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AopApplicationTests {

    @Resource
    UserMapper userMapper ;

    @Test
    void contextLoads() {
        int i = userMapper.selectONe();
        System.out.println(i);
    }

}
