package com.example.logbackdemo.com.test.source.Async.action;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @program: source-demo
 * @description: 库存服务类
 * @ClassName：RepoService
 * @author: Mr.Wang
 * @create: 2022-02-10 17:47
 **/
@Service
public class RepoService {

    /**
     * 查询指定商品的库存
     * @param groupId
     * @return
     */
    public Integer getRepoByGroupId(Integer groupId){
        return new Random().nextInt(1000);
    }

}
