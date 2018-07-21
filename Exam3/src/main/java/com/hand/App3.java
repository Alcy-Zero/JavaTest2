package com.hand;

import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        System.out.println("请输入股票代码：");
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println("[INFO] 股票编码：");
        Get g = new Get(str);
        System.out.println("[INFO] 开始获取数据。。。。。。");
        String result = g.getInfo();
        System.out.println("[INFO] 获取数据成功!");

        CreateJson cj = new CreateJson(result);
        cj.start();

        CreateXML cx = new CreateXML(result);
        cx.start();
    }
}
