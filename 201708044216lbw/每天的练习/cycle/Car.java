package com.atguigu.spring.beans.cycle;

/**
 * @Auther: LBW
 * @Date: 2019/3/30
 * @Description: com.atguigu.spring.beans.cycle
 * @version: 1.0
 */
public class Car {
    private String Brand;

    public Car() {
        System.out.println("Car Constor..");
    }

    public void setBrand(String brand) {
        System.out.println("set Brand..");
        Brand = brand;
    }

    public void init()
    {
          System.out.println("init....");
    }

    public void destory()
    {
        System.out.println("destory..");
    }

}
