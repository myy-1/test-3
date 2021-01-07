package com.example.aop.mapper;

import com.example.aop.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 马月月
 * @Date: 2021/1/6 15:39
 * @Description:
 */
@Mapper
public interface UserMapper {
    /**
     * 分页查询用户
     * @return
     */
  List<User> selectPage();

}
