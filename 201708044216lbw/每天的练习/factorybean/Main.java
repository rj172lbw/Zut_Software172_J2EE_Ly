package com.atguigu.spring.beans.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: LBW
 * @Date: 2019/3/31
 * @Description: com.atguigu.spring.beans.factorybean
 * @version: 1.0
 */
public class Main
{
    public static void main(String []args)
    {
        ApplicationContext  app = new ClassPathXmlApplicationContext("Beans-beanfactory.xml");
        Car littlecar = (Car)app.getBean("car");
        System.out.println(littlecar);
    }

}
