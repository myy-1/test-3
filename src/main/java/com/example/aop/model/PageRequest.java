package com.example.aop.model;

import lombok.Data;

/**
 * @Author: 马月月
 * @Date: 2021/1/6 15:53
 * @Description:分页请求
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private  int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
}
