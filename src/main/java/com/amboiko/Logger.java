package com.amboiko;

import java.util.concurrent.atomic.AtomicBoolean;

public class Logger implements Runnable {
    private volatile Integer id;

    public static AtomicBoolean flag = new AtomicBoolean(false);

    public Logger() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            if (flag.get()) {
                System.out.println("GET: " + id);
                flag.set(false);
            }
        }
    }

    public void setId(Integer id) {
        this.id = id;
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
