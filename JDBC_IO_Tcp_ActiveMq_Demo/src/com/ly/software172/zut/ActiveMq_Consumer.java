package com.ly.software172.zut;

public class ActiveMq_Consumer {

    public class Consumer implements Runnable {
        ActiverMq_Consumer_Demo activerMq_consumer_demo;
        String QueueName;

        public Consumer(ActiverMq_Consumer_Demo activerMq_consumer_demo, String queueName) {
            this.activerMq_consumer_demo = activerMq_consumer_demo;
            QueueName = queueName;
        }

        @Override
        public void run() {
            activerMq_consumer_demo.getMessage(QueueName);
        }
    }

}
