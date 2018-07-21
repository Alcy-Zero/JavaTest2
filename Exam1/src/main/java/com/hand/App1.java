package com.hand;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class App1 {
    public static void main(String[] args) {
        download("http://192.168.11.205:18080/trainning/SampleChapter1.pdf","Exam1/tmp/SampleChapter1.pdf");
    }

    public static void download(String url, String filepath) {
        try {
            HttpClient client = HttpClients.createDefault();//new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = client.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            File file = new File(filepath);
            file.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buffer = new byte[10000];
            int ch = 50;
            while ((ch = is.read(buffer)) != -1) {
                fos.write(buffer, 0, ch);
            }
            System.out.println("文件下载成功。");
            is.close();
            fos.flush();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

