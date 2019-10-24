package com.lsm.feigndemo.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Enhancer;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 17:19
 */
@Data
public class FeignDemoClientFactoryBean implements FactoryBean {

    private Class<?> interfaceCls;

    public FeignDemoClientFactoryBean() {
    }

    @Override
    public Object getObject() throws Exception {
        Object object = proxy();
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceCls;
    }

    public Object proxy() {
        final Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(interfaceCls);
        enhancer.setCallback(new FeignDemoClientProxy());
        enhancer.setClassLoader(interfaceCls.getClassLoader());
        return enhancer.create();
    }
}
