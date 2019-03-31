package com.atguigu.spring.beans.collections;

import com.atguigu.spring.beans.car;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/3/24
 * @Description: com.atguigu.spring.beans
 * @version: 1.0
 */
public class person
{
    private String name;
    private int money;
    private List <car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<car> getCars() {
        return cars;
    }

    public void setCars(List<car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString()
    {
        return "person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", cars=" + cars +
                '}';
    }
}
