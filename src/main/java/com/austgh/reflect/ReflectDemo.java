package com.austgh.reflect;

import java.lang.reflect.Field;

public class ReflectDemo<T>{
    public boolean[][] b = {{true, true}, {false, false}};
    public String name = "shixinzhang";
    public Integer integer = 23;
    public T type;
    public static final String CLASS_NAME = "com.spring.codestudy.reflect.ReflectDemo";

    public static void main(String[] args) throws Exception {
        testGetType();
    }

    public static void main1() throws Exception{
        A a = new A();
        Field field1 = a.getClass().getDeclaredField("x");
        field1.setAccessible(true);
        field1.set(a, 1);
        System.out.println(a.getX());
//--------------------------------------------------------------
        Person person = new Person();
        person.setName("VipMao");
        person.setAge(24);
        person.setSex("男");
        //通过Class.getDeclaredField(String name)获取类或接口的指定属性值。
        Field f1 = person.getClass().getDeclaredField("name");
        System.out.println("-----Class.getDeclaredField(String name)用法-------");
        f1.setAccessible(true);
        System.out.println(f1.get(person));
//---------------------------------------------------------------
        System.out.println("-----Class.getDeclaredFields()用法-------");
        //通过Class.getDeclaredFields()获取类或接口的指定属性值。
        Field[] f2 = person.getClass().getDeclaredFields();
        for (Field field: f2) {
            field.setAccessible(true);
            System.out.println(field.get(person));
        }
        //修改属性值
        System.out.println("----修改name属性------");
        f1.set(person, "Maoge");
        //修改后再遍历各属性的值
        Field[] f3 = person.getClass().getDeclaredFields();
        for (Field fields: f3) {
            fields.setAccessible(true);
            System.out.println(fields.get(person));
        }
    }

    public static void testGetSet() throws Exception {
        Person person =new Person();
        //通过Class.getDeclaredField(String name)获取类或接口的指定已声明字段。
        Field f1=person.getClass().getDeclaredField("name");
        System.out.println("-----Class.getDeclaredField(String name)用法-------");
        System.out.println(f1);
        f1.setAccessible(true);
        System.out.println("-----Class.getDeclaredFields()用法-------");
        //通过Class.getDeclaredFields()获取类或接口的指定已声明字段。
        Field []f2=person.getClass().getDeclaredFields();
        for(Field field:f2)
        {
            System.out.println(field);
        }
        System.out.println("-----Class.getField(String name)用法-------");
        //通过Class.getField(String name)返回一个类或接口的指定公共成员字段，私有成员报错。
        Field f3=person.getClass().getField("name");
        System.out.println(f3);
        //如果获取age属性(私有成员) 则会报错
        //Field f3=person.getClass().getField("name");
        System.out.println("-----Class.getFields()用法-------");
        //通过Class.getField()，返回 Class 对象所表示的类或接口的所有可访问公共字段。
        Field []f4=person.getClass().getFields();
        for(Field fields:f4)
        {
            //因为只有name属性为共有，因此只能遍历出name属性
            System.out.println(fields);
        }
    }

    public static void testGetType(){
        try {
            Class<?> aClass = Class.forName(CLASS_NAME);
            Field[] fields = aClass.getFields();
            for (Field field : fields) {
                System.out.println(field.getName());
                System.out.println( field.getType().getCanonicalName());
                System.out.println(field.getGenericType().toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
