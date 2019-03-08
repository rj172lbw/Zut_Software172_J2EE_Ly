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

            ActiveMq_Producter_Demo activeMq_producter_demo = new ActiveMq_Producter_Demo();
            activeMq_producter_demo.init();
            /*
            ActiveMq_Producter activeMq_producter = new ActiveMq_Producter();
            new Thread(activeMq_producter.new Productor(activeMq_producter_demo, "Ygg")).start();
            */

            while(true) {
                System.out.println("TcpServerThread_Listen_OK!");
                String message = reader.readLine();
                //String txtDate = null;
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String date = simpleDateFormat.format(calendar.getTime());
                Operation.insert(new Message(message, date));
                System.out.println("客户端信息接收："+ message);
                /*
                activeMq_producter_demo.sendMessage("Ygg1", message + " (" + date + ") ");
                activeMq_producter_demo.sendMessage("Ygg2", message + " (" + date + ") ");
                */
                ActiveMq_Producter activeMq_producter = new ActiveMq_Producter();
                new Thread(activeMq_producter.new Productor(activeMq_producter_demo, "Ygg01", message + " (" + date + ") ")).start();
                new Thread(activeMq_producter.new Productor(activeMq_producter_demo, "Ygg02", message + " (" + date + ") ")).start();
                new Thread(activeMq_producter.new Productor(activeMq_producter_demo, "Ygg03", message + " (" + date + ") ")).start();
                //new Thread(activeMq_producter.new Productor(activeMq_producter_demo, "Ygg04", message + " (" + date + ") ")).start();
                //new Thread(activeMq_producter.new Productor(activeMq_producter_demo, "Ygg05", message + " (" + date + ") ")).start();
                //new Thread(activeMq_producter.new Productor(activeMq_producter_demo, "Ygg06", message + " (" + date + ") ")).start();


                //txtDate = Operation.getAll();
                //writer.println(txtDate);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
