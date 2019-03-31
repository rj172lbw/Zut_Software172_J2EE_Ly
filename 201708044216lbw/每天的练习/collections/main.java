package com.atguigu.spring.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: LBW
 * @Date: 2019/3/26
 * @Description: com.atguigu.spring.beans.collections
 * @version: 1.0
 */
public class main
{
     public static void main(String []args)
     {
         ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
         person p = (person)app.getBean("person3");
         System.out.println(p);

         System.out.println("**********************");
         newperson np = (newperson) app.getBean("person4");
         System.out.println(np);

         System.out.println("**********************");
         person p1 = (person) app.getBean("person5");
         System.out.println(p1);

         System.out.println("**********************");
         person p2 = (person) app.getBean("person6");
         System.out.println(p2);
     }
}
