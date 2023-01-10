package com.austgh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable  和Runner 去吧就是是否带返回值
 * 但 future.get() 阻塞
 */
public class T03_Callable {
    public static void main(String[] args) throws Exception{
        Callable<String> c=new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("程序开始");
                Thread.sleep(10000);  //休眠10秒
                return "hello world!";
            }
        };
        ExecutorService service= Executors.newCachedThreadPool();
        Future<String> future=service.submit(c);//异步
        System.out.println(future.get());  //同步阻塞   要等线程执行完结果，一直在阻塞
        service.shutdown();
    }
}
