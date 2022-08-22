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

        if (fileManager.getFile().exists()) {
            new Producer(provider);
            new Consumer(provider, logger);
        }
    }
}
