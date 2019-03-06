package com.lbw.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @Auther: LBW
 * @Date: 2019/3/6
 * @Description: com.lbw.Controller
 * @version: 1.0
 */
public class Main
{
    public static void main(String []args)
    {
      ApplicationContext act = new ClassPathXmlApplicationContext("META-INF/ApplicationContext.xml");
      Hello_Word helloworld = (Hello_Word) act.getBean("HelloWorld");
      helloworld.Hello();
    }
}
