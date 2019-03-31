package com.atguigu.spring.beans.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: LBW
 * @Date: 2019/3/30
 * @Description: com.atguigu.spring.beans.cycle
 * @version: 1.0
 */
public class Main
{
     public static void main(String []args)
     {
         ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("Beans-cycle.xml");

         Car car = (Car) app.getBean("car");
         System.out.println(car);

         //使用destory关闭IOC容器
         app.close();
     }
}
