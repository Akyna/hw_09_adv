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
        while (count < 20) {
            count++;
            try {
                Thread.sleep(1000);
                synchronized (provider) {
//                    int id = (int) (Math.random() * 100);
                    provider.list.add(new Record(count));
                    System.out.println("PRODUCED: " + count);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
