package com.concurrent.source.Async.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: source-demo
 * @description:
 * @ClassName：GoodsController
 * @author: Mr.Wang
 * @create: 2022-02-10 17:49
 **/
@RestController
public class GoodsController {

    @Autowired
    GoodService goodssService;

    @Autowired
    CommentService commentService;

    @Autowired
    RepoService repoService;

    @GetMapping("/goods")
    public List<Goods> goods() throws InterruptedException, ExecutionException {
        //使用supplyAsync()方法来构建一个CompletableFuture任务，这个任务负责查询所有商品的基本信息
        CompletableFuture<List<Goods>> goodsFuture = CompletableFuture.supplyAsync(() ->goodssService.queryGoods());
       //通过thenApplyAsync()方法来连接另外一个任务，也就是当第一个查询商品基本信息的CompletionStage任务执行结束后，通过异步线程执行第二个任务
        CompletableFuture cf = goodsFuture
                .thenApplyAsync(goods ->{goods
                        .stream().map(goods1 -> CompletableFuture
                        .supplyAsync(() ->{goods1.setRepo(repoService.getRepoByGroupId(goods1.getId()));
            return goods1;
            //使用了thenCompose()方法来组合两个CompletionStage任务，完成商品评论和商品库存信息的补充。
        }).thenCompose(goods2 -> CompletableFuture.supplyAsync(()->{
            goods2.setComment(commentService.getCommentList(goods2.getId()));
            return goods2;
        }))).toArray(size->new CompletableFuture[size]);
            return goods;
        });
        //采用handleAsync()方法返回执行结果，这里用handleAsync()方法的目的是避免将前置任务的异常直接抛给前端
        return (List<Goods>) cf.handleAsync((goods, th)->th!=null ?"系统繁忙":goods).get();
    }
}

