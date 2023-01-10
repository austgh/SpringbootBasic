package com.austgh.jvm;

import com.austgh.entity.User;

/**
 *  * 栈上分配，标量替换
 *  * 代码调用了1亿次alloc()，如果是分配到堆上，大概需要1GB以上堆空间，如果堆空间小于该值，必然会触发GC。
 *  * 使用如下参数不会发生GC
 *  *默认逃逸分析和标量替换参数 开启的 jdk 1.7之后
 *  * -Xmx15M -Xms15M -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 *  * 使用如下参数都会发生大量GC
 *  * -Xmx15M -Xms15M -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 *  * -Xmx15M -Xms15M -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 *  */
public class AllotOnStack {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void alloc() {
        User user = new User();
        user.setId(1);
        user.setName("zhuge");
    }
}
