package com.concurrent.source.Async.action;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @program: source-demo
 * @description: 商品信息服务类
 * @ClassName：GoodService
 * @author: Mr.Wang
 * @create: 2022-02-10 17:45
 **/
@Service
public class GoodService {

    public List<Goods> queryGoods(){
        return Arrays.asList(
                new Goods(1,"电脑",new BigDecimal(5000)),
                new Goods(2,"手机",new BigDecimal(3500)),
                new Goods(3,"手表",new BigDecimal(1200)),
                new Goods(4,"桌子",new BigDecimal(50))
        );
    }
}

