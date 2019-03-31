package com.atguigu.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Auther: LBW
 * @Date: 2019/3/31
 * @Description: com.atguigu.spring.beans.factorybean
 * @version: 1.0
 */
     public class CarFactoryBean implements FactoryBean<Car>
{
    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Car getObject() throws Exception {
        //返回bean的对象
        return new Car(brand , 400000);
    }


    @Override
    public Class<?> getObjectType() {
        //返回bean的类型
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
