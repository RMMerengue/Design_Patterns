package com.msb.Iterator.v05;

import com.msb.Iterator.v03.ArrayList_;
import com.msb.Iterator.v03.Collection_;

public class Main {
    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());

       Iterator_ it = list.iterator();
       while(it.hasNext()){
           Object o = it.next();
           System.out.println(o);
       }
    }
}
