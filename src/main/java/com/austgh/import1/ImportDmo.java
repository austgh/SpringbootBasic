package com.austgh.import1;

import com.austgh.object.A;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


/**
 *实现ImportBeanDefinitionRegistrar 接口
 * @Import 对应的实现类的时候，会调用registerBeanDefinitions方法
 */
public class ImportDmo implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(A.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("gonghe");
        registry.registerBeanDefinition("testA",beanDefinition);
    }
}
