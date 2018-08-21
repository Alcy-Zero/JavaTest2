package com.hand;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class App2 {
    public static void main(String[] args) {
        {
            int port = 8080;
            try {
                Thread t1 = new MySocketServer(port);
                Thread t2 = new MySocket();
                t1.start();
                sleep(3000);
                t2.start();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
