package com.amboiko;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("report/data.txt");
        try {
            fileManager.createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Provider provider = new Provider();
        Logger logger = new Logger(fileManager);

        System.out.println(fileManager.getFile().exists());
        if (fileManager.getFile().exists()) {
            new Producer(provider);
            new Consumer(provider, logger);

//            while (true){
//                System.out.println("----------------------");
//                System.out.println(provider.list.size());
//                provider.list.forEach(System.out::println);
//                System.out.println("----------------------");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
