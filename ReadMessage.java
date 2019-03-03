package J2EE小组项目尝试1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Auther: LBW
 * @Date: 2019/3/2
 * @Description: J2EE小组项目尝试1
 * @version: 1.0
 */
public class ReadMessage
{
     String  str = null;      //string 类型的字符串
    public String print ()
    {
        File file = new File("D:\\Java\\IDEAWorkShop\\src\\J2EE小组相关\\ReadFiler.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader IPSR = new InputStreamReader(fis);
            BufferedReader BR = new BufferedReader(IPSR);
            str = BR.readLine();
            /*
            while ((str = BR.readLine()) != null) {
                System.out.println("输出文件里的数据1：" + str);
                return str;
            }
            */
            System.out.println("输出文件里的数据2：" + str);
            fis.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }
    public static void main(String []args)
    {
        ReadMessage RM = new ReadMessage();
        System.out.println(RM.print());
    }
}
