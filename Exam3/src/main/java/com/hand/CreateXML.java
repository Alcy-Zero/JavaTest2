package com.hand;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;


public class CreateXML extends Thread {
    private String result;

    CreateXML(String result) {
        this.result = result;
    }

    public void run() {
        try {
            String[] ss;
            ss = result.split(",");
            String[] ssx;
            ssx = ss[0].split("\"");
            ss[0] = ssx[1];

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("xml");
            Element lan1 = document.createElement("stock");
            Element n10 = document.createElement("name");
            n10.setTextContent(ss[0]);
            Element n11 = document.createElement("open");
            n11.setTextContent(ss[1]);
            Element n12 = document.createElement("close");
            n12.setTextContent(ss[2]);
            Element n13 = document.createElement("current");
            n13.setTextContent(ss[3]);
            Element n14 = document.createElement("high");
            n14.setTextContent(ss[4]);
            Element n15 = document.createElement("low");
            n15.setTextContent(ss[5]);

            lan1.appendChild(n10);
            lan1.appendChild(n11);
            lan1.appendChild(n12);
            lan1.appendChild(n13);
            lan1.appendChild(n14);
            lan1.appendChild(n15);

            root.appendChild(lan1);
            document.appendChild(root);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("encoding", "UTF-8");

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            transformer.transform(new DOMSource(document), new StreamResult(new File
                    ("Exam3\\tmp\\股票编码.xml")));

            System.out.println("[INFO] 解析为xml成功!");
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}