package com.atguigu.spring.beans.factorybean;

/**
 * @Auther: LBW
 * @Date: 2019/3/28
 * @Description: com.atguigu.spring.beans.autowire
 * @version: 1.0
 */
public class Car
{
    private String brand;
    private int price;

    public Car(String brand , int price)
    {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

