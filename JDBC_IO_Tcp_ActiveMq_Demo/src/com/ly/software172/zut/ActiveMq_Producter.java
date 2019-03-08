package com.ly.software172.zut;

public class ActiveMq_Producter {
    public class Productor implements Runnable {
        private ActiveMq_Producter_Demo activeMq_producter_demo;
        private String queueName;
        private String Message_Date;

        public Productor(ActiveMq_Producter_Demo activeMq_producter_demo, String queueName, String message_Date) {
            this.activeMq_producter_demo = activeMq_producter_demo;
            this.queueName = queueName;
            Message_Date = message_Date;
        }

        @Override
        public void run() {
            activeMq_producter_demo.sendMessage(queueName, Message_Date);
        }
    }
}
