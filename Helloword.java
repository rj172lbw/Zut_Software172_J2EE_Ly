package com.javaee.Cui.controller;

public class Helloword {
    public String name;

    public void setName(String name) {
        this.name = name;
    }
    //@org.springframework.beans.factory.annotation.Autowired(required=true)

    public void hello() {
        System.out.print("hello:" + name);
    }
}
