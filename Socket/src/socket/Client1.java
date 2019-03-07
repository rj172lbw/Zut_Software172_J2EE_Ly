package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

    void client1() throws IOException {
        Socket c = new Socket("localhost",8888);
        PrintWriter writer = new PrintWriter(c.getOutputStream(),true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
        System.out.println("输入消息:");
        Scanner in = new Scanner(System.in);
            String context = in.nextLine();
            writer.println(context);
            reader.close();
            writer.close();
            c.close();
    }
    public static void main(String[] args) throws IOException {
        Client1 c = new Client1();
        c.client1();
    }
}
