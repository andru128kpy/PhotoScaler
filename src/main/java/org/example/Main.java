package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File inputFolder = new File("imagesfirst");
        File outputFolder = new File("images");

        if (!outputFolder.exists()) {
            inputFolder.mkdir();
        }
        File[] files = inputFolder.listFiles();

        File[] files1 = new File[files.length/2];
        File[] files2 = new File[files.length - files1.length];

        System.arraycopy(files, 0, files1, 0, files1.length);
        System.arraycopy(files, files1.length, files2, 0, files2.length);

        PhotoScaler test = new PhotoScaler(files1, outputFolder);
        test.run();

    }
}