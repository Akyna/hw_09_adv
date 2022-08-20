package com.amboiko;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Producer implements Runnable {
    private final Provider provider;

    public Producer(Provider provider) {
        this.provider = provider;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Producer block started");
        int count = 0;
        while (count < 100) {
            count++;
            try {
                Thread.sleep(2000);
                synchronized (provider) {
                    int id = (int) (Math.random() * 100);
                    provider.list.add(new Record(id));
                    System.out.println("PRODUCED: " + id);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
