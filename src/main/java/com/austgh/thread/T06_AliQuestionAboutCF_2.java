package com.austgh.thread;

import org.apache.logging.log4j.message.ReusableMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 如何优雅的停止一个线程
 * 首先确定任务类型 计算型 CPU密集 没有wait等阻塞操作 还是IO密集型 好多阻塞等待操作 停止方式不是完全相同
 * cup 密集型 使用设置标志位  标志位需要使用volatile修饰
 * IO密集型 使用interrupt
 */

/**
 * 分布式多个任务同时执行，如果有一个执行失败，则所有的任务都停止执行
 */
public class T06_AliQuestionAboutCF_2 {
    static enum Result {
        SUCCESS, FAIl, CANCELLED
    }
    static List<MyTask> tasks = new ArrayList(); //list 不是线程安全的

    public static void main(String[] args) {
        MyTask task1 = new MyTask("task1", 1, Result.FAIl);
        MyTask task2 = new MyTask("task2", 40, Result.SUCCESS);
        MyTask task3 = new MyTask("task3", 1, Result.FAIl);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        for (MyTask task : tasks) {
            //异步执行任务，执行完调用回调函数 task 异步执行runTask 方法，执行完毕后，调用callback 函数
            CompletableFuture f = CompletableFuture.supplyAsync(() -> task.runTask()).thenAccept((result) -> callback(result, task));
        }
    }

    /*
    要考虑并发问题 同步   最主要的是思考 可能存在的问题  分布式2pc 3pc 以及幂等 或者是否还有其他要考虑的 CAP 理论
     */

    private static void callback(Result result, MyTask task) {
        /**
         * 可以处理的精确一下，根据不同的任务状态，做出到底是取消还是忽略这样的处理 2pc
         * 这里要考虑同步，除非cancel无状态，幂等，否则应该同步
         * 如果有两个任务同时失效呢，需要考虑这种情况
         */
        if (Result.FAIl == result) {
            for (MyTask _task : tasks) {
                if (_task != task) {
                    _task.cancel();
                }
            }
        }
    }

    private static class MyTask {
        private String name;
        private int timeInSeconds;
        private Result ret;
        volatile boolean cancelling = false;
        volatile boolean cancelled = false;

        public MyTask(String name, int timeInSeconds, Result ret) {
            this.name = name;
            this.timeInSeconds = timeInSeconds * 1000;
            this.ret = ret;
        }

        public Result runTask() {
            int interval = 100;
            int total = 0;
            try {
                for (; ; ) {                //可以采用打桩形式
                    Thread.sleep(interval);   //cup 密集型
                    total += interval;
                    if (total > timeInSeconds) break;
                    if (cancelled) return Result.CANCELLED;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "end!");
            return ret;
        }

        /**
         *
         * 不需要双重检查吧
         * 双重检查检查的是变量
         */
        public void cancel() {
            if(!cancelled){
                synchronized (this) {
                    if(!cancelled) return;
                    cancelling = true;
                    System.out.println(name + "cancelling");
                    try {
                        TimeUnit.MICROSECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + "cancelled");
                    cancelled = true;
                }
            }
        }
    }
}
