package com.lsm.feigndemo.factory;

import com.lsm.feigndemo.config.FeignDemoClient;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Set;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 17:25
 */
public class FeignDemoClientScanner extends ClassPathBeanDefinitionScanner {

    public FeignDemoClientScanner(final BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(final String... basePackages) {
        final Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        if (CollectionUtils.isEmpty(beanDefinitionHolders)) {
            System.out.println("No InfClient was found in " + Arrays.toString(basePackages));
            return beanDefinitionHolders;
        }

        for (BeanDefinitionHolder holder : beanDefinitionHolders) {
            final GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
            definition.getPropertyValues().add(InjectionProperties.INTERFACE_CLASS, definition.getBeanClassName());
            definition.setBeanClass(FeignDemoClientFactoryBean.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        }
        return beanDefinitionHolders;
    }

    @Override
    public boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().hasAnnotation(FeignDemoClient.class.getName());
    }

    /**
     * 需要注入的属性
     */
    private interface InjectionProperties {
        String RESOURCE = "resource";
        String INTERFACE_CLASS = "interfaceCls";
        String WEB_CLIENT_REPOSITORY = "webClientRepository";
    }
}
