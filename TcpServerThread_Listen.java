package com.ly.software172.zut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TcpServerThread_Listen extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public TcpServerThread_Listen(Socket socket) {
        super();
        this.socket = socket;
        start();
    }

    @Override
    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(),true);
            while(true) {
                System.out.println("TcpServerThread_Listen_OK!");
                String txt = reader.readLine();
                String txtDate = null;
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String date = simpleDateFormat.format(calendar.getTime());
                Operation.insert(new Message(txt, date));
                System.out.println("客户端信息接收："+ txt);
                /*txtDate = Operation.getAll();
                writer.println(txtDate);*/

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
