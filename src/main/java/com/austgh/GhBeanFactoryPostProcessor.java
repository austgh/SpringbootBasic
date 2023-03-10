package com.austgh;

import com.austgh.object.A;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class GhBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
        //System.out.println(beanDefinition.getBeanClass());

        beanFactory.registerSingleton("user",new A("gh"));
    }
}
