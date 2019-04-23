package com.daojia.study.servlet;

import com.daojia.study.annotation.MyController;
import com.daojia.study.annotation.MyRequestMapping;
import com.daojia.study.annotation.MyRequestParam;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.*;

/**
 * Created by xiachao on 2018/8/1 20:41
 */
public class MyDispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 7631462261132531893L;

    private Properties properties = new Properties();

    private List<String> classNames = new ArrayList<>();

    //ioc容器
    private Map<String, Object> ioc = new HashMap<>();

    //处理器映射器
    private Map<String, Method> handlerMapping = new HashMap<>();

    //url controller关联
    private Map<String, Object> controllerMap = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {

        //1, 初始化配置文件
        initConfig(config.getInitParameter("contextConfigLocation"));

        //2, 初始化所有相关联的类 扫描包
        doScanner(properties.getProperty("scanPackage"));

        //3, 拿到扫描到的类 通过反射机制 实例化  并放到ioc容器 k-v beanName - bean
        try {
            doInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //4, 初始化handlerMApping （将url和method对应上）
        try {
            initHandlerMapping();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void initHandlerMapping() throws IllegalAccessException, InstantiationException {

        if (ioc.isEmpty()) return;

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class clazz = entry.getValue().getClass();
            if (clazz.isAnnotationPresent(MyController.class)) {

                String baseUrl = "";
                if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                    MyRequestMapping annotation = (MyRequestMapping) clazz.getAnnotation(MyRequestMapping.class);
                    baseUrl = annotation.value();
                }

                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(MyRequestMapping.class)) {
                        MyRequestMapping annotation = (MyRequestMapping) method.getAnnotation(MyRequestMapping.class);
                        String url = annotation.value();

                        url = "/" + baseUrl + "/" + url;
                        handlerMapping.put(url, method);
                        controllerMap.put(url, clazz.newInstance());
                        System.out.println("url=" + url + " , method=" + method);
                    }
                }
            }

        }

    }

    private void doInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (classNames.isEmpty()) return;

        for (String className : classNames) {
            Class clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(MyController.class)) {
                ioc.put(toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
            }
        }

    }

    private String toLowerFirstWord(String name) {
        char[] charArray = name.toCharArray();
        charArray[0] += 32;
        return String.valueOf(charArray);
    }

    private void doScanner(String scanPackage) {

        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replace(".", "/"));
        File dir = new File(url.getFile());

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                String className = scanPackage + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }

    }

    private void initConfig(String contextConfigLocation) {

        InputStream inputStream = this.getClass().getResourceAsStream("/" + contextConfigLocation);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (handlerMapping.isEmpty()) return;

        String url = req.getRequestURI();
        String contextPAth = req.getContextPath();

        url = url.replace(contextPAth, "");

        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404!!!!!!!!!!!!!!!!!!");
        }

        Method method = this.handlerMapping.get(url);

        //获取参数类型
        Class<?>[] parameterTypes = method.getParameterTypes();

        Object[] paramValues = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            String requestParam = parameterTypes[i].getSimpleName();

            if (requestParam.equals("HttpServletRequest")) {
                paramValues[i] = req;
                continue;
            }
            if (requestParam.equals("HttpServletResponse")) {
                paramValues[i] = resp;
                continue;
            }
            if (requestParam.equals("String")) {

                Map<String, String[]> requestParams = req.getParameterMap();

                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                String[] paramsNames = new String[parameterAnnotations.length];
                int m = 0;
                for (Annotation[] annotations : parameterAnnotations) {
                    for (Annotation annotation : annotations) {
                        if (annotation instanceof MyRequestParam) {
                            paramsNames[m++] = ((MyRequestParam) annotation).value();
                        }
                    }
                }

                //获取参数名称
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.println("parameterName=" + parameter.getName());
                }

                if (paramsNames.length > 0) {
                    //通过@MyRequestParam赋值
                    paramValues[i] = req.getParameter(paramsNames[i]);
                } else {
                    for (Map.Entry<String, String[]> param : requestParams.entrySet()) {
                        //若传入多个param值 只取第一个值
                        String value = param.getValue()[0];
                        paramValues[i] = value;
                    }
                }
            }
        }

        try {
            method.invoke(controllerMap.get(url), paramValues);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
