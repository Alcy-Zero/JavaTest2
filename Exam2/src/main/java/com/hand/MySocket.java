package com.hand;

import java.io.*;
import java.net.Socket;

public class MySocket extends Thread {
    @Override

    public void run() {
        String serverName = "localhost";
        int port = 8080;
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());

            File file = new File("Exam2/tmp/SampleChapter1.pdf");
            FileOutputStream fos = new FileOutputStream(file);

            InputStream is = client.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            byte[] b = new byte[10000];
            while ((bis.read(b) != -1)) {
                fos.write(b);
            }
            fos.flush();

            bis.close();
            is.close();
            fos.close();

            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}