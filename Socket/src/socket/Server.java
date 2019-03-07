package socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    void server() throws IOException {
        ServerSocket s = new ServerSocket(8888);
        Socket c = s.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
        PrintWriter writer = new PrintWriter(c.getOutputStream());
        System.out.println("接收到的信息为:"+reader.readLine());
        reader.close();
        writer.close();
        s.close();
        c.close();
    }
    public static void main (String[] args) throws IOException {
        Server s = new Server();
        s.server();
    }
}
