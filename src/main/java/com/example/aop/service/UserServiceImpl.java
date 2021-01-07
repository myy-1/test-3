package com.example.aop.service;

import com.example.aop.mapper.UserMapper;
import com.example.aop.model.PageRequest;
import com.example.aop.model.PageResult;
import com.example.aop.model.User;
import com.example.aop.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 马月月
 * @Date: 2021/1/7 16:37
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    private PageInfo<User> getPageInfo(PageRequest pageRequest){
        int  pageNum = pageRequest.getPageNum();
        int  pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
//        List<User> menu=userMapper.selectPage();
        List<User> menu = null ;
        return new PageInfo<User>(menu);
    }


    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }
}
