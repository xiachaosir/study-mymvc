package com.daojia.study.tomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xiachao
 * @date 2019/6/6 16:26
 */
public class MyRequest {

    private String url;

    private String method;

    public MyRequest(InputStream inputStream) throws IOException {
        System.out.println("-------------request start------------");
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            httpRequest =  new String(httpRequestBytes, 0 , length);
        }

        String httpHead = httpRequest.split("\n")[0];
        System.out.println("httpHead:" + httpHead);
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
