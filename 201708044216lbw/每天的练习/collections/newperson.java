package com.atguigu.spring.beans.collections;

import com.atguigu.spring.beans.car;

import java.util.List;
import java.util.Map;

/**
 * @Auther: LBW
 * @Date: 2019/3/26
 * @Description: com.atguigu.spring.beans.collections
 * @version: 1.0
 */
public class newperson
{
    private String name;
    private int money;
    private Map < String , car> cars;

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

    public Map<String, car> getCars() {
        return cars;
    }

    public void setCars(Map<String, car> cars) {
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

