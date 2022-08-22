package com.amboiko;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Logger implements Runnable {
    private volatile List<Integer> list;
    private FileManager fileManager;
    FileWriter fr;
    BufferedWriter br;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static AtomicBoolean flag = new AtomicBoolean(false);

    public Logger(FileManager fileManager) {
        this.fileManager = fileManager;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            if (flag.get()) {
                try {
                    fr = new FileWriter(fileManager.getFile(), true);
                    br = new BufferedWriter(fr);
                    for (Integer id : list) {
                        br.newLine();
                        br.write("ID: " + id + " Date: " + sdf.format(new Date()));
                    }
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                flag.set(false);
            }
        }
    }

    public void setIds(List<Integer> list) {
        this.list = list;
    }

}
