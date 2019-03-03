package J2EE小组项目尝试1;

import J2EE小组相关.ClientThread;
import J2EE小组相关.Server;

import java.io.*;
import java.net.Socket;

/**
 * @Auther: LBW
 * @Date: 2019/3/1
 * @Description: J2EE小组项目尝试1
 */

public class MyClient
{
    ReadMessage RM = new ReadMessage();
    public void client ()
    {
        int port = 30000;
        String host = "localhost";
        try
        {
            Socket so = new Socket(host , port);
            new Thread(new ClientThread(so)).start();
            PrintStream dos = new PrintStream(so.getOutputStream());
            System.out.println("连接完成！");
            dos.print(RM.print());
            dos.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String []args)
    {
        MyClient  myclient = new MyClient();
        System.out.println("开始运行客户端！");
        myclient.client();
    }

}
