package com.daojia.study.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFor {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        /*for (int i = 0; i < stringList.size(); i++) {
            if ("a".equals(stringList.get(i))) {
                stringList.remove(stringList.get(i));
            }
            System.out.println(stringList.get(i));
        }*/

        //foreach时会转换成iterator iterato.next()方法会checkModification(即比较modCount == expectModeCount)
       /* for (String str : stringList) {
            if ("a".equals(str)) {
                stringList.remove(str);
            }
            System.out.println(str);
        }*/

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("a".equals(next)) {
                iterator.remove(); //iterator的remove方法会设置 expectedModCount = modCount;;
            }
        }

    }
}
