package com.amboiko;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {
    private final Provider provider;
    private final Logger logger;

    public Consumer(Provider provider, Logger logger) {
        this.provider = provider;
        this.logger = logger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Consumer block started");
        int count = 0;
        while (count < 5) {
            count++;
            try {
                Thread.sleep(4000);
                synchronized (provider) {
                    List<Integer> listForReport = new ArrayList<>();
                    for (Record r : provider.list) {
                        listForReport.add(r.getId());
                        provider.list.remove(r);
                    }
                    logger.setIds(listForReport);
                    Logger.flag.set(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}