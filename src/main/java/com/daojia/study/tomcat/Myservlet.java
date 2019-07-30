package com.daojia.study.tomcat;

import com.daojia.study.servlet.MyDispatcherServlet;

import java.io.IOException;

/**
 * @author xiachao
 * @date 2019/6/6 16:40
 */
public abstract class Myservlet {

    public abstract void doGet(MyRequest myRequest, MyResponse myResponse) throws IOException;

    public abstract void doPost(MyRequest myRequest, MyResponse myResponse) throws IOException;

    public void service(MyRequest myRequest, MyResponse myResponse) throws IOException {
        if ("POST".equalsIgnoreCase(myRequest.getMethod())) {
            doPost(myRequest, myResponse);
        } else if ("GET".equalsIgnoreCase(myRequest.getMethod())) {
            doGet(myRequest, myResponse);
        }
    }


}
