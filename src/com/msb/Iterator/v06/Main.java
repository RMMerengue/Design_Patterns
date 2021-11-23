package com.msb.Iterator.v06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Collection list = new ArrayList();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());

       Iterator it = list.iterator();
       while(it.hasNext()){
           Object o = it.next();
           System.out.println(o);
       }
    }
}
