package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.*;

public class Client {
     private void client() throws IOException {
         Socket c = new Socket("localhost", 8888);
         BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
         PrintWriter writer = new PrintWriter(c.getOutputStream());
         String context = reader.readLine();
         System.out.println("接收到服务器的语句是：" + context);
         reader.close();
         writer.close();
         c.close();

     }
    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.client();
    }
}
