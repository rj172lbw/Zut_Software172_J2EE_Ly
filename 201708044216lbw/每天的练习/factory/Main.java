package com.atguigu.spring.beans.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: LBW
 * @Date: 2019/3/31
 * @Description: com.atguigu.spring.beans.factory
 * @version: 1.0
 */
public class Main
{
    public static void main(String []args)
    {
        ApplicationContext app = new ClassPathXmlApplicationContext("Beans-factory.xml");
        Car c = (Car) app.getBean("car");
        System.out.println(c);
        System.out.println("------------------");
        Car c2 = (Car) app.getBean("car2");
        System.out.println(c2);
    }
}
