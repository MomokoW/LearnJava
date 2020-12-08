package com.momoko.solutions;

/**
 * Created by momoko on 2019/12/26
 *
 * @author momoko
 */

import java.util.concurrent.CompletableFuture;

/**
 * 同时从新浪和网易查询证券代码，只要任意一个返回结果，就进行下一步查询价格，查询价格也同时从新浪和网易查询，只要任意一个返回结果，就完成操作：
 */

/**
 * CompletableFuture可以指定异步处理流程：
 *
 * thenAccept()处理正常结果；
 * exceptional()处理异常结果；
 * thenApplyAsync()用于串行化另一个CompletableFuture；
 * anyOf()和allOf()用于并行化多个CompletableFuture。
 */
public class QueryStockAndPrice {
    public static void main(String[] args) throws InterruptedException {
        // 用两个CompletableFuture执行异步查询
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> queryCode("中国石油", "https://finance.sina.com.cn/code/"));
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> queryCode("中国石油", "https://money.163.com/code/"));

        // 用anyOf合并为一个新的CompletableFuture
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> fetchPrice((String) code, "https://finance.sina.com.cn/price/"));
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> fetchPrice((String) code, "https://money.163.com/price/"));

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> System.out.println("price: " + result));
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");

        try {
            Thread.sleep((long) (Math.random() * 1000));
        }catch ( InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 5 + Math.random() * 20;
    }

}
