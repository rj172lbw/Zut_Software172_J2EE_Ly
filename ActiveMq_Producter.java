package com.ly.software172.zut;

public class ActiveMq_Producter {
    private class Productor implements Runnable {
        ActiveMq_Producter_Demo activeMq_producter_demo;

        public Productor(ActiveMq_Producter_Demo activeMq_producter_demo) {
            this.activeMq_producter_demo = activeMq_producter_demo;
        }

        @Override
        public void run() {
            while (true) {
                activeMq_producter_demo.sendMessage("Ygg");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        ActiveMq_Producter_Demo activeMq_producter_demo = new ActiveMq_Producter_Demo();
        activeMq_producter_demo.init();
        ActiveMq_Producter activeMq_producter = new ActiveMq_Producter();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(activeMq_producter.new Productor(activeMq_producter_demo)).start();
        
    }
}
