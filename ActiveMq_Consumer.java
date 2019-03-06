package com.ly.software172.zut;

public class ActiveMq_Consumer {

    private  class Consumer implements Runnable {
        ActiverMq_Consumer_Demo activerMq_consumer_demo;

        public Consumer(ActiverMq_Consumer_Demo activerMq_consumer_demo) {
            this.activerMq_consumer_demo = activerMq_consumer_demo;
        }

        @Override
        public void run() {
            while (true) {
                activerMq_consumer_demo.getMessage("Ygg");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ActiverMq_Consumer_Demo activerMq_consumer_demo = new ActiverMq_Consumer_Demo();
        activerMq_consumer_demo.init();
        new Thread(new ActiveMq_Consumer().new Consumer(activerMq_consumer_demo)).start();
    }
}
