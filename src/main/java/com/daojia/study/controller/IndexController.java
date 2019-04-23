package com.daojia.study.controller;

import com.daojia.study.annotation.MyController;
import com.daojia.study.annotation.MyRequestMapping;
import com.daojia.study.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiachao on 2018/8/1 20:44
 */
@MyController
@MyRequestMapping("a")
public class IndexController {


    @MyRequestMapping(value = "index")
    public void index(@MyRequestParam(value = "param") String param, HttpServletResponse response, HttpServletRequest request) {

        System.out.println("index方法被执行");
        try {
            response.getWriter().write("success!!!!!!!!!!!!!!!!!!param="+param);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
