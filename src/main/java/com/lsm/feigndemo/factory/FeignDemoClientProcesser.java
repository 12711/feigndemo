package com.lsm.feigndemo.factory;

import com.lsm.feigndemo.config.FeignDemoClient;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Set;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 17:25
 */
public class FeignDemoClientProcesser implements ApplicationContextAware, ResourceLoaderAware, BeanDefinitionRegistryPostProcessor {

    private ApplicationContext resource;
    private ResourceLoader resourceLoader;
    private String[] basePackages;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.resource = applicationContext;
    }

    @Override
    public void setResourceLoader(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void setBasePackages(final String[] basePackages) {
        this.basePackages = basePackages;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(final BeanDefinitionRegistry registry) throws BeansException {
        FeignDemoClientScanner scanner = new FeignDemoClientScanner(registry);
        scanner.setResourceLoader(this.resourceLoader);
        scanner.resetFilters(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(FeignDemoClient.class));
        scanner.scan(basePackages);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    }
}
