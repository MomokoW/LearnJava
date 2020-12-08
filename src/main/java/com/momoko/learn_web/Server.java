package com.momoko.learn_web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Created by momoko on 2020/6/26.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(8080)) {  //监听指定的端口
            System.out.println("sever is running...");
            while(true) {
                Socket sc = ss.accept();
                System.out.println("connected from " + sc.getRemoteSocketAddress());
                Thread t = new Handler(sc);
                t.start();
            }
        }
    }
}
class Handler extends Thread {
    Socket sock;

    public Handler(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try (InputStream input = sock.getInputStream()) {
            try (OutputStream output = sock.getOutputStream()) {
                handle(input, output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));

        //处理Http请求
        boolean requestOk = false;
        String first = reader.readLine();
        if (first.startsWith("GET / HTTP/1.")) {
            requestOk = true;
        }
        while (true) {
            String header = reader.readLine();
            if (header.isEmpty()) {  //读取到空行时, HTTP Header读取完毕
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOk ? "Response OK" : "Response Error");
        if (!requestOk) {
            //发送错误响应
            writer.write("404 Not Found\r\n");
            writer.write("Content-Length:0\r\n");
            writer.write("\r\n");
            writer.flush();
        } else {
            //成功发送响应
            String data = "<html><body><h1>Hello, world!</h1></body></html>";
            int length = data.getBytes(StandardCharsets.UTF_8).length;
            writer.write("HTTP/1.0 200 OK\r\n");
            writer.write("Connection:close\r\n");
            writer.write("Content-Type:text/html\r\n");
            writer.write("Content-Length:" + length + "\r\n");
            writer.write("\r\n");    // 空行标识Header和Body的分隔
            writer.write(data);
            writer.flush();
        }

    }
}