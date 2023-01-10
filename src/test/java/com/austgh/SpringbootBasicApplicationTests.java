package com.austgh;

import com.austgh.annotation.GhAnnotation;
import com.austgh.contronl.OrderController;
import com.austgh.service.UserService;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringbootBasicApplication.class)
class SpringbootBasicApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(SpringbootBasicApplicationTests.class);
    @Test
    void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
//        System.out.println(context.getBean("user"));
////        A a = (A) context.getBean("testA");
////        System.out.println(a.getName());
//        context.registerBean("hello",A.class,"gonghe");
//        System.out.println("-------------->"+context.getBean("hello"));
//        A userA = (A) context.getBean("userA");
//        System.out.println("--------:"+userA);
        System.out.println(context.getBean("lubanFactoryBean"));
        UserService userService= (UserService) context.getBean("userService");
    }
    @Test
    void test1(){
        OrderController orderController=new OrderController();
        //获取对应的属性 使用反射
        Class<OrderController> clazz = OrderController.class;
        Stream.of( clazz.getDeclaredFields()).forEach(filed->{
            if( filed.getAnnotation(GhAnnotation.class)!=null){
                Class<?> type = filed.getType();//返回属性类型就是OrderService
                System.out.println("-------->"+filed.getGenericType());
                //反射 调用set
                filed.setAccessible(true);
                System.out.println(type);
                try {
                    Object o = type.newInstance();
                    filed.set(orderController,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(orderController.getOrderService());
    }
}
