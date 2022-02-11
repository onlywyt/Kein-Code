package com.example.logbackdemo.com.test.source.Async.action;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @program: source-demo
 * @description: 商品评价信息服务类
 * @ClassName：CommentService
 * @author: Mr.Wang
 * @create: 2022-02-10 17:42
 **/
@Service
public class CommentService {
    /**
     * 返回指定商品评论
     */
    public List<String> getCommentList(Integer goodsId){
        return Arrays.asList("好","一般","不好");
    }
}
