package com.momoko;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by momoko on 2021/1/18.
 */
public class TCPTest2 {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 6666);
        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream(new File("犬夜叉.png"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1) {
            os.write(buffer,0,len);
        }

        fis.close();
        os.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("filereceive.png"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0 , len);
        }

        fos.close();
        is.close();
        socket.close();


    }


}