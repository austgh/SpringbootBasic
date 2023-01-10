package com.austgh.thread;

import java.util.concurrent.CompletableFuture;

public class T06_AliQuestionAboutCF {
    static enum Result{
        SUCCESS,FAIl,CANCELLED
    }
    public static void main(String[] args) throws Exception{
        MyTask task1=new MyTask("task1",3,true);
        MyTask task2=new MyTask("task2",4,true);
        MyTask task3=new MyTask("task3",1,false);
        CompletableFuture f1 = CompletableFuture.supplyAsync(() -> task1.call()).thenAccept((result) -> callback(result));
        CompletableFuture f2 = CompletableFuture.supplyAsync(() -> task2.call()).thenAccept((result) -> callback(result));
        CompletableFuture f3 = CompletableFuture.supplyAsync(() -> task3.call()).thenAccept((result) -> callback(result));
        System.in.read();
    }

    /**
     * 这个callback 实现有问题 本来60分现在直接给20分
     *    //处理结束流程
     *    //通知其他线程结束(回滚)
     *    //超时处理
     */
    private static void callback(Boolean result){
        if(result==false){
            //直接杀死进程有问题，比如数据库操作，System.exit 将会把连接什么的都退出。
            System.exit(0);
        }
    }
    private static class MyTask{
        private String name;
        private int timeInSeconds;
        private Boolean ret;
        volatile boolean cancelling=false;
        volatile boolean  cancelled=false;
        public MyTask(String name,int timeInSeconds,boolean ret){
            this.name=name;
            this.timeInSeconds=timeInSeconds*1000;
            this.ret=ret;
        }
        public Boolean call(){
            //模拟业务执行时间
            //实际中时间不固定，可能在处理计算任务，或者是IO任务
            try{
                Thread.sleep(timeInSeconds);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(name +"task callback");
            return ret;
        }
    }
}
