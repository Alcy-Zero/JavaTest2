package com.hand;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

class Get {
    private CloseableHttpClient client = HttpClients.createDefault();
    private String num;

    Get(String num) {
        this.num = num;
    }

    String getInfo(){

        HttpGet get = new HttpGet("http://hq.sinajs.cn/list=" + num);
        String result = null;
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}