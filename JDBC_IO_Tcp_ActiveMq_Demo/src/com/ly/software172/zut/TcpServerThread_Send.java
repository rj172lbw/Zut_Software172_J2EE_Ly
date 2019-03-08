package com.ly.software172.zut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpServerThread_Send extends Thread {

    private Socket socket;
    private String queueName;
    private BufferedReader reader;
    private PrintWriter writer;

    public TcpServerThread_Send(Socket socket) {
        super();
        this.socket = socket;
        start();
    }
    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);

            String queueName = reader.readLine();
            System.out.println(queueName);
            System.out.println("客户端信息接收："+ reader.readLine());

            ActiverMq_Consumer_Demo activerMq_consumer_demo = new ActiverMq_Consumer_Demo(socket);
            activerMq_consumer_demo.init();
            new Thread(new ActiveMq_Consumer().new Consumer(activerMq_consumer_demo, queueName)).start();

            /*
            Integer Number = Operation.getNumber();
            while(true) {
                sleep(1000);
                Integer number = Operation.getNumber();
                if(number != Number) {
                    String txtDate = null;
                    txtDate = Operation.getAll();
                    //sleep(5000);
                    writer.println(txtDate);
                    System.out.println("TcpServerThread_Send_OK!");
                    Number = number;
                }
                else {
                    System.out.println("客户端未发来信息，服务端无信息传输！");
                }
            }
        */
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
