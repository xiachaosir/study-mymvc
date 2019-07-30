package com.daojia.study.tomcat;

import java.io.IOException;

/**
 * @author xiachao
 * @date 2019/6/6 16:43
 */
public class HelloWorldServlet extends Myservlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) throws IOException {
        myResponse.write("get hello world");
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) throws IOException {
       myResponse.write("post hello world");
    }
}
