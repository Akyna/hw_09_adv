package com.amboiko;

public class Producer implements Runnable {
    private final Provider provider;

    public Producer(Provider provider) {
        this.provider = provider;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                synchronized (provider) {
                    int id = (int) (Math.random() * 100);
                    provider.list.add(new Record(id));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
