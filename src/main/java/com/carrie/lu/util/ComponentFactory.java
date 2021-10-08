package com.carrie.lu.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ComponentFactory implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ComponentFactory.context = applicationContext;
    }

    public static <T> T $(Class<T> clazz, Object... params) {
        if(params.length == 0) {
            return context.getBean(clazz);
        } else {
            return context.getBean(clazz, params);
        }
    }

}
