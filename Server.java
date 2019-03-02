package demo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args)throws IOException
    {
        ServerSocket server=new ServerSocket(8888);
        System.out.println("服务器启动时间是:"+new Date());
        Socket client=server.accept();
        DataInputStream inputfromClient=new DataInputStream(client.getInputStream());
        DataOutputStream outputtoClient=new DataOutputStream(client.getOutputStream());
        while(true)
        {
            double ridus=inputfromClient.readDouble();
            double area=ridus*ridus*Math.PI;
            System.out.println("服务端：当前接收的半径为："+ridus);
            System.out.println("服务端：计算面积为："+area);
            outputtoClient.writeDouble(area);
        }
    }
}
