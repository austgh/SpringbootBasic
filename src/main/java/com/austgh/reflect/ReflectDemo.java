package com.austgh.reflect;

import java.lang.reflect.Field;

public class ReflectDemo<T> {
    public static void main(String[] args) throws Exception {
        main1();
    }

    public static void main1() throws Exception {
        Person person = new Person();
        person.setName("VipMao");
        person.setAge(24);
        person.setSex("男");
        //通过Class.getDeclaredField(String name)获取类或接口的指定属性值。
        Field f1 = person.getClass().getDeclaredField("name");
        f1.setAccessible(true);
        System.out.println(f1.get(person));
        //通过Class.getDeclaredFields()获取类或接口的指定属性值。
        Field[] f2 = person.getClass().getDeclaredFields();
        for (Field field : f2) {
            field.setAccessible(true);
            System.out.println(field.get(person));
        }
        //修改属性值
        System.out.println("----修改name属性------");
        f1.set(person, "Maoge");
        //修改后再遍历各属性的值
        Field[] f3 = person.getClass().getDeclaredFields();
        for (Field fields : f3) {
            fields.setAccessible(true);
            System.out.println(fields.get(person));
        }
    }
}
