package com.hand;

public class App3 {
    public static void main(String[] args) {
        System.out.println("[INFO]股票编码：");
        Get g = new Get(args[0]);
        System.out.println("[INFO] 开始获取数据。。。。。。");
        String result = g.getInfo();
        System.out.println("[INFO] 获取数据成功!");

        CreateJson cj = new CreateJson(result);
        cj.start();

        CreateXML cx = new CreateXML(result);
        cx.start();
    }
}
