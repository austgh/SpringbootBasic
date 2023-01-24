package com.austgh.IOC;

import com.austgh.annotation.GhAnnotation;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * 模拟springIoc容器功能
 */
public class SpringIOC {
    public static void main(String[] args) {
        //OrderController orderController=new OrderController();
        //Class<? extends OrderController> clazz = orderController.getClass();
        //Stream.of(clazz.getDeclaredFields()).forEach(filed->{
        //    if(filed.getAnnotation(GhAnnotation.class)!=null){
        //        filed.setAccessible(true);
        //    }
        //});
    }

    //public static void main(String[] args) {
    //    OrderController orderController = new OrderController();
    //    //使用Stream 遍历OrderController上的属性上是否有对应的注解
    //    //1.获取对应类上的属性
    //    final Field[] declaredFields = OrderController.class.getDeclaredFields();
    //    for(Field filed:declaredFields){
    //        //判断上面是否有GHAnnotation 注解
    //        final GhAnnotation annotation = filed.getAnnotation(GhAnnotation.class);
    //        if(annotation!=null){
    //            filed.setAccessible(true);
    //        }
    //    }
    //}
}
