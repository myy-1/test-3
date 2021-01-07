package com.example.aop.service;

import com.example.aop.mapper.UserMapper;
import com.example.aop.model.PageRequest;
import com.example.aop.model.PageResult;
import com.example.aop.model.User;
import com.example.aop.util.PageUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 马月月
 * @Date: 2021/1/6 15:43
 * @Description:
 */
@Service
public interface UserService {

    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
     PageResult findPage(PageRequest pageRequest);
}
