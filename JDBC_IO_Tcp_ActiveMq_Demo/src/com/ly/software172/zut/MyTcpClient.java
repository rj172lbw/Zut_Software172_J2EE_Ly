package com.ly.software172.zut;
//客户端程序

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class MyTcpClient {

    private PrintWriter writer;
    private BufferedReader reader;
    Socket socket;

    public void connect(){
        System.out.println("尝试连接");
        try{
            socket = new Socket("0.0.0.0",8866);
            writer = new PrintWriter(socket.getOutputStream(),true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("连接成功");
            Scanner in = new Scanner(System.in);
            String string = null;
            writer.println("你好，来自客户端的连接");
            /*
            Thread.sleep(1000);
            System.out.println("MyTcpClient信息接收：" + reader.readLine());
            */
            while(true) {
                //Thread.sleep(10000);
                string = in.nextLine();
                writer.println(string);
                //writer.println(Reader.Reader_MyTcpClient());
                /*
                Thread.sleep(1000);
                System.out.println("MyTcpClient信息接收：" + reader.readLine());
                */
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTcpClient tcpclient;
        tcpclient = new MyTcpClient();
        tcpclient.connect();
    }
}


