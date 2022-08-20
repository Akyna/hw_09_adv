package com.amboiko;

import java.io.File;
import java.io.IOException;

public class FileManager {
    private final File file;

    public FileManager(String filePath) {
        file = new File(filePath);
    }


    void createFile() throws IOException {
        if (file.getParentFile().mkdirs()) {
            file.createNewFile();
        }
    }

    public File getFile() {
        return file;
    }
}
