package com.daojia.study.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiachao
 * @date 2019/6/6 16:46
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "com.daojia.study.tomcat.HelloWorldServlet"));
    }
}
