package com.amboiko;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Logger implements Runnable {
    private volatile List<Integer> list;
    private  FileManager fileManager;
    FileWriter fr;
    BufferedWriter br;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static AtomicBoolean flag = new AtomicBoolean(false);

    public Logger(FileManager fileManager) {
        this.fileManager = fileManager;
//        try {
//            fr = new FileWriter(fileManager.getFile(), true);
//            br = new BufferedWriter(fr);
//            br.write("-=START=- Date: " + sdf.format(new Date()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        new Thread(this).start();
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (flag.get()) {
                System.out.println("WRITE");
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
//        try {
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void setIds(List<Integer> list) {
        this.list = list;
    }
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(new Date()));
//        System.out.println(System.getProperty("user.dir"));

//    File reportFile = new File("report/data.txt");
//        reportFile.getParentFile().mkdirs();
//        if (reportFile.createNewFile()) {
//        System.out.println("sss");
//    }
//
//    FileWriter fr = new FileWriter(reportFile, true);
//    BufferedWriter br = new BufferedWriter(fr);
//        br.newLine();
//        br.write("data1");
//
//        br.close();
//        fr.close();

}
