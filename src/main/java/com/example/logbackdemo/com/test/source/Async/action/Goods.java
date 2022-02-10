package com.example.logbackdemo.com.test.source.Async.action;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: source-demo
 * @description: 异步查询商品类
 * @ClassName：Goods
 * @author: Mr.Wang
 * @create: 2022-02-10 17:37
 **/
@Data
@Getter
public class Goods {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer repo;
    private Integer buyerNum;
    private List<String> comment;

    public Goods(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
