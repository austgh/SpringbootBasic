package com.austgh.jvm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class Main {
    public static void main(String[] args) {
        System.out.println("方法开始！");
        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        map.computeIfAbsent(
                "AaAa",
                key -> {
                    return map.computeIfAbsent(
                            "BBBB",
                            key2 -> 42);
                }
        );
        System.out.println("方法结束 map="+map);
    }
}