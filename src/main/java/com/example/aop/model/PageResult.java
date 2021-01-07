package com.example.aop.model;

import lombok.Data;

import java.util.List;

/**
 * @Author: 马月月
 * @Date: 2021/1/6 15:48
 * @Description:
 */
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private  int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     *记录的总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private  int totalPages;
    /**
     * 数据模型
     */
    private List<?> content;

}
