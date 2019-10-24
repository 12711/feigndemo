package com.lsm.feigndemo.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsm.feigndemo.config.EnableFeignDemoClient;
import com.lsm.feigndemo.config.FeignDemoClient;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Map;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 16:49
 */
@NoArgsConstructor
@Data
public class FeignDemoRegisterBean implements ImportBeanDefinitionRegistrar {
    private ResourceLoader resourceLoader;

    public FeignDemoRegisterBean(final ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 获取当前注解标注的类
        final Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableFeignDemoClient.class.getName());
        try {
            System.out.println("当前注解标注的类信息如下：" + new ObjectMapper().writeValueAsString(annotationAttributes));
            BeanDefinition beanDefinition = new RootBeanDefinition(FeignDemoClientProcesser.class);
            beanDefinition.getPropertyValues().add("basePackages", annotationAttributes.get("basePackages"));
            registry.registerBeanDefinition("FeignDemoEnableConfig", beanDefinition);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
