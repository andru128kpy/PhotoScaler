package org.example;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;

public class PhotoScaler extends Thread {
    private File[] files;
    private File outputFolder;

    public PhotoScaler(File[] files, File outputFolder) {
        this.files = files;
        this.outputFolder = outputFolder;
    }

    @Override
    public void run() {
        if (files != null) {
            for (File file : files) {
                try {
                    File copressedFile = new File(outputFolder.getPath() + File.separator + file.getName());
                    Thumbnails.of(file)
                            .size(200, 200)
                            .outputFormat("jpg")
                            .toFile(copressedFile);
                    System.out.println("Изображение " + file.getName() + "сжато и сохранино как" + copressedFile.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
