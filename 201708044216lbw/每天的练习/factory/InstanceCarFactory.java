package com.atguigu.spring.beans.factory;

/**
 * @Auther: LBW
 * @Date: 2019/3/31
 * @Description: com.atguigu.spring.beans.factory
 * @version: 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂的方法， 先创建工厂本身，在调用工厂的实例方法来返回bean的实力
 */
public class InstanceCarFactory
{
    private Map<String , Car> cars = null;

    public InstanceCarFactory()
    {
        cars = new HashMap<String , Car>();
        cars.put("we" , new Car("we" , 30000));
        cars.put("rng" , new Car("rng" , 40000));
    }
    public  Car getCar(String brand)
    {
        return cars.get(brand);
    }
}
