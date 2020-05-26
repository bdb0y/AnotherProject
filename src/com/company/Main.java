package com.company;

import java.io.File;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) throws Exception {
        URL website = new URL("https://cdn.aminrezaei.workers.dev/sx5c_tdd1.mp4");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileChannel fos = FileChannel.open(Paths.get("myNewFile11.mp4"),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE);
        long currentTime = System.currentTimeMillis();
        fos.transferFrom(rbc, 0, Long.MAX_VALUE);
        long finishedTime = System.currentTimeMillis();
        File file = new File("myNewFile11.mp4");
        long fileSize = file.length() / 1000;
        System.out.println("The file size is: " + fileSize);
        System.out.println(fileSize / ((finishedTime - currentTime) / 1000));
    }
}
