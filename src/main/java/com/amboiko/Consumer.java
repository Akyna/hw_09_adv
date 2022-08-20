package com.amboiko;

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
        while (count < 100) {
            count++;
            try {
                Thread.sleep(4000);
                synchronized (provider) {
                    for (Record r : provider.list) {
                        // FIXME: не працює
                        logger.setId(r.getId());
                        Logger.flag.set(true);
                        provider.list.remove(r);
                        System.out.println("REMOVED: " + r.getId());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}