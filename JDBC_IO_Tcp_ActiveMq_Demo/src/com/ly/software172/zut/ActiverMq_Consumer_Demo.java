package com.ly.software172.zut;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class ActiverMq_Consumer_Demo {

    private Socket socket;
    private static final String userName = ActiveMQConnection.DEFAULT_USER;
    private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String broker_Url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public ActiverMq_Consumer_Demo(Socket socket) {
        this.socket = socket;
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);
    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;
    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<MessageConsumer>();

    public void init() {
        connectionFactory = new ActiveMQConnectionFactory(userName, passWord, broker_Url);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void getMessage(String string) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            Queue queue = session.createQueue(string);
            MessageConsumer messageConsumer = null;
            if(threadLocal.get() != null) {
                messageConsumer = (MessageConsumer) threadLocal.get();
            } else {
                messageConsumer = session.createConsumer(queue);
                threadLocal.set(messageConsumer);
            }
            while (true) {
                //Thread.sleep(1000);
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if(textMessage != null) {
                    textMessage.acknowledge();
                    System.out.println(Thread.currentThread().getName() +
                            "接收到: " + textMessage.getText() + "-->" + atomicInteger.getAndIncrement());
                    writer.println(textMessage.getText());
                    System.out.println("TcpServerThread_Send_OK!");
                } else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}