package com.daojia.study.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiachao on 2018/8/8 10:59
 */
public class StringUtil {

    int i;

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap();
        hashMap.put(3,"A");
        hashMap.put(7,"B");
        hashMap.put(5, "C");

        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("key = " + entry.getKey() + ",value=" + entry.getValue());
        }

       /* List<String> list = Arrays.asList("1");
        Object[] objects = list.toArray();
        if (objects.getClass() == Object[].class) {
            System.out.println("true");
        }else {
            System.out.println("false");
            Object[] objects1 = Arrays.copyOf(objects, objects.length, Object[].class);
            System.out.println(objects1);
        }

        objects[0] = new String();

        System.out.println(objects);*/


        /*String str1 = "abcd";//先检查字符串常量池中有没有"abcd"，如果字符串常量池中没有，则创建一个，然后 str1 指向字符串常量池中的对象，如果有，则直接将 str1 指向"abcd""；
        String str2 = new String("abcd");//堆中创建一个新的对象
        String str3 = new String("abcd");//堆中创建一个新的对象
        System.out.println(str1==str2);//false
        System.out.println(str2==str3);//false
        System.out.println(str1 == str3);*/


        /*String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println(s2);//计算机
        System.out.println(s1 == s2);//false，因为一个是堆内存中的 ze 对象一个是常量池中的 String 对象，
        System.out.println(s3 == s2);//true，因为两个都是常量池中的 String 对象*/


       /* System.out.println("RUNNING= " + (-1 << 29) );
        System.out.println("SHUTDOWN= " + (0 << 29) );
        System.out.println("STOP= " + (1 << 29) );
        System.out.println("TIDYING= " + (2 << 29) );
        System.out.println("TERMINATED= " + (3 << 29) );

        System.out.println( -536870912 | 0 );*/


        /*for (int i = 0; i < 10; i++) {
            if (i ==2) {
                break;
            }
            System.out.println("i="+i);
        }*/
       /* List<StringUtil> list = new ArrayList<StringUtil>();
        System.out.println("111111");*/
        /*while (true) {
            list.add(new StringUtil());
        }
*/

    }

    public void play() {
        i++;
        play();
    }

    //通过不断的创建新的线程使Stack内存耗尽
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    private void dontStop() {
        while (true) {

        }
    }
}
