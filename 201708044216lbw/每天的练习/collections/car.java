package com.atguigu.spring.beans.collections;

/**
 * @Auther: LBW
 * @Date: 2019/3/24
 * @Description: com.atguigu.spring.beans
 * @version: 1.0
 */
public class car
{
    private String  brand;
    private String cirp;
    private int price;
    private int maxspeed;

    public car(String  brand , String cirp , int price , int maxspeed)
    {

        this.brand = brand;
        this.cirp = cirp;
        this.maxspeed = maxspeed;
        this.price = price;
    }
    public car(String brand , int price , int maxspeed)   //不同的构造器
    {
        this.brand = brand;
        this.price = price;
        this.maxspeed = maxspeed;

    }
    @Override
    public String toString() {
        return "*car=" + brand + "*cirp=" + cirp + "*maxspeed" + maxspeed + "*price" + price;
    }
}
