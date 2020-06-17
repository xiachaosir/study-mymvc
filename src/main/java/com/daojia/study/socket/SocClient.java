package com.daojia.study.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author xiachao
 * @since 2020/4/22 11:15
 */
public class SocClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 65000);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.write("我是客户端，请求连接");
        printWriter.flush();
        socket.shutdownOutput();

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info = null;
        while ((info = bufferedReader.readLine()) != null) {
            System.out.println("收到服务端请求" + info);
        }

        bufferedReader.close();
        inputStreamReader.close();
        //socket.shutdownInput();

    }
}
