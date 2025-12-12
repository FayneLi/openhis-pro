package org.openhis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class SpringBeanLister implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void listAllSpringBeans() {
        // 获取容器中所有Bean的名称
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        // 排序便于查看
        Arrays.sort(beanNames);

        System.out.println("=====  Spring容器中管理的Bean类列表  =====");
        for (String beanName : beanNames) {
            // 获取Bean的类型
            Class<?> beanType = applicationContext.getType(beanName);
            if (beanType != null) {
                System.out.println(beanType.getName());
            }
        }
        System.out.println("=======================================");
        System.out.println("总数量: " + beanNames.length);
    }
}