package com.ly.software172.zut;
//客户端程序

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class TcpClient_2 {
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
            writer.println("你好，来自TcpClient_2的连接");
            getserverMessage();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void getserverMessage(){
        try{
            while(true){
                System.out.print("TcpClient_2信息接收：");
                System.out.println(reader.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if(reader != null){
                reader.close();
            }
            if(writer != null){
                writer.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TcpClient_2 tcpClient_2;
        tcpClient_2 = new TcpClient_2();
        tcpClient_2.connect();
    }
}


