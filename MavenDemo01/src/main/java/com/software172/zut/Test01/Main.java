package com.software172.zut.Test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //HelloWord helloWord = new HelloWord();
        //1.创建spring的ioc容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        //2.从ioc容器中获取bean实例
        HelloWorld helloWord = (HelloWorld) applicationContext.getBean("HelloWorld!");
        helloWord.hello();
    }

}
