package com.austgh;

import com.austgh.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class GhFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        System.out.println("只调用一次!");
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
