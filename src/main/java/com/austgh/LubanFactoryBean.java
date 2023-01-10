package com.austgh;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Component
public class LubanFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
//            Object o= Proxy.newProxyInstance(LubanFactoryBean.class.getClassLoader(), new
//            Class[]{UserMapper.class},new InvocationHandler(){
////                @Override
////                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                    System.out.println(method.getName());//调用toString 方法
////                 if(Object.class.equals(method.getDeclaringClass())){
////                     return method.invoke(this,args);
////                 }
////                return null;
////                }
////            });
////            return o;
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return Object.class;
    }
}
