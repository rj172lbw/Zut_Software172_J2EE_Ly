package com.atguigu.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Auther: LBW
 * @Date: 2019/3/31
 * @Description: com.atguigu.spring.beans.cycle
 * @version: 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor
{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("postProcessBeforeInitialization:--- " + bean + "," + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
    {
        System.out.println("postProcessAfterInitialization:--- " + bean + "," + beanName);
        return bean;
    }
}
