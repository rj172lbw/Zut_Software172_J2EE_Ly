package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class helloClient {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("localhost",8888);
        BufferedReader br=new BufferedReader(new InputStreamReader((client.getInputStream())));
        String context=br.readLine();
        System.out.println("当前服务器端输出的语句是: "+context);
        br.close();
        client.close();
    }
}
