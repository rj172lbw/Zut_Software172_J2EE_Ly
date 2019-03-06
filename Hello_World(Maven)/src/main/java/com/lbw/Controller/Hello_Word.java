package com.lbw.Controller;

/**
 * @Auther: LBW
 * @Date: 2019/3/6
 * @Description: com.lbw.Controller
 * @version: 1.0
 */
public class Hello_Word
{
    public String name;
    public void setName(String name)        //这个函数名字要写的标准为setName
    {
        this.name = name;
    }
    public void Hello()
    {
        System.out.println("hello" + name);
    }

}
