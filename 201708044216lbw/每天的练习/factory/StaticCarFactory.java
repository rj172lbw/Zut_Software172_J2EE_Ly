package com.atguigu.spring.beans.factory;


import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: LBW
 * @Date: 2019/3/31
 * @Description: com.atguigu.spring.beans.factory
 * @version: 1.0
 */
public class StaticCarFactory
{

    private static Map<String , Car> cars = new HashMap<String, Car>();

    static
    {
        cars.put("we" , new Car("we" , 400000));
        cars.put("rng" , new Car("rng" , 4050450));
    }

    //静态工厂方法
    public static Car getCar(String name)
   {
      return cars.get(name);
   }
}
