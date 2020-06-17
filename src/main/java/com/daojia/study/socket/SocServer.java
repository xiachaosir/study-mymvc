package com.daojia.study.socket;

import com.daojia.study.proxy.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xiachao
 * @since 2020/4/22 11:08
 */
public class SocServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(65000);
        String info = null;
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while ((info = bufferedReader.readLine()) != null) {
            System.out.println("收到的信息=" + info);
        }
        socket.shutdownInput();

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.write("同意请求");
        printWriter.flush();

        inputStream.close();
        bufferedReader.close();
        //socket.shutdownOutput();
        //socket.close();
        //serverSocket.close();
    }
}
