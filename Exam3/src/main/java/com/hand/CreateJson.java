package com.hand;

import com.google.gson.JsonObject;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateJson extends Thread {
    private String result;

    CreateJson(String result) {
        this.result = result;
    }

    @Override
    public void run() {

        String[] ss;
        ss = result.split(",");
        String[] ssx;
        ssx = ss[0].split("\"");
        ss[0] = ssx[1];

        JsonObject jo = new JsonObject();
        jo.addProperty("name", ss[0]);
        jo.addProperty("open", ss[1]);
        jo.addProperty("close", ss[2]);
        jo.addProperty("current", ss[3]);
        jo.addProperty("high", ss[4]);
        jo.addProperty("low", ss[5]);

        try {
            FileOutputStream fos = new FileOutputStream("Exam3/tmp/股票编码.json");
            fos.write(jo.toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("[INFO] 解析为json成功!");

    }
}
