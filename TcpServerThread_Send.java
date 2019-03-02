package com.ly.software172.zut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpServerThread_Send extends Thread {
    private Socket socket;
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
            System.out.println("TcpServerThread_Send_OK!");
            System.out.println("客户端信息接收："+ reader.readLine());
            while(true) {
                System.out.println("TcpServerThread_Send_OK!");
                String txtDate = null;
                txtDate = Operation.getAll();
                sleep(5000);
                writer.println(txtDate);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
