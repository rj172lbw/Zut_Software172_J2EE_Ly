package demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args)throws IOException
    {
        Socket client=new Socket("localhost",8888);
        Scanner sc=new Scanner(System.in);
        DataInputStream fromServer=new DataInputStream(client.getInputStream());
        DataOutputStream toServer=new DataOutputStream(client.getOutputStream());
        while(true)
        {
            System.out.println("请输入半径：");
            double ridus=sc.nextDouble();
            toServer.writeDouble(ridus);
            toServer.flush();
            double area=fromServer.readDouble();
            System.out.println("客户端：输入的半径是："+ridus);
            System.out.println("客户端：接受到的面积为："+area);
        }
    }
}
