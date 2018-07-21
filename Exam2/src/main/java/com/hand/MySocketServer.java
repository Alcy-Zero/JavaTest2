package com.hand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

class MySocketServer extends Thread
{
    private ServerSocket serverSocket;

    MySocketServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(60000);
    }

    @Override
    public void run()
    {
        while(true)
            try {
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to "
                        + server.getRemoteSocketAddress());

                File file = new File("Exam1/tmp/SampleChapter1.pdf");
                FileInputStream fis = new FileInputStream(file);

                OutputStream os = server.getOutputStream();
                BufferedOutputStream bos = new BufferedOutputStream(os);

                byte[] b = new byte[10000];
                while ((fis.read(b))!=-1) {
                    bos.write(b);
                }
                bos.flush();

                bos.close();
                os.close();
                fis.close();

                server.close();         //server,not serverSocket
                serverSocket.close();

            } catch (SocketException e) {
                System.out.println("服务器关闭！");
                break;
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
    }
}