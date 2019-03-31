package com.atguigu.spring.beans.factory;

/**
 * @Auther: LBW
 * @Date: 2019/3/28
 * @Description: com.atguigu.spring.beans.autowire
 * @version: 1.0
 */
public class Car
{
    private String brand;
    private String price;

    public Car(String brand , int price)
    {
        System.out.println("创建了一个实例！");
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

