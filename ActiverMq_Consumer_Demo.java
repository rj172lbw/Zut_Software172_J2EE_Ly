package com.ly.software172.zut;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class ActiverMq_Consumer_Demo {
    private static final String userName = ActiveMQConnection.DEFAULT_USER;
    private static final String passWord = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String broker_Url = ActiveMQConnection.DEFAULT_BROKER_URL;

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
            Queue queue = session.createQueue(string);
            MessageConsumer messageConsumer = null;
            if(threadLocal.get() != null) {
                messageConsumer = (MessageConsumer) threadLocal.get();
            } else {
                messageConsumer = session.createConsumer(queue);
                threadLocal.set(messageConsumer);
            }
            while (true) {
                Thread.sleep(1000);
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if(textMessage != null) {
                    textMessage.acknowledge();
                    System.out.println(Thread.currentThread().getName() +
                            "接收到: " + textMessage.getText() + "-->" + atomicInteger.getAndIncrement());
                } else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}