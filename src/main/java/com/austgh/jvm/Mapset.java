package com.austgh.jvm;

import java.util.concurrent.ConcurrentHashMap;

public class Mapset {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
        String why=map.get("why");
        System.out.println("第一次获取why值："+why);
        why=map.computeIfAbsent("why",key->getValue());
        System.out.println("第二次获取why："+why);
    }
    public static String getValue(){
        return "why 技术";
    }
}
