package socket;

import Hello.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class helloServer {
    public static void main(String[] args)throws IOException
    {
        ServerSocket server=new ServerSocket(8888);
        System.out.println("服务员器运行，等待客户端连接");
        Socket client=server.accept();
        OutputStream out=client.getOutputStream();
        PrintWriter pw=new PrintWriter(out);
        pw.println("hello world");
        pw.close();
        client.close();
        server.close();
    }

}
