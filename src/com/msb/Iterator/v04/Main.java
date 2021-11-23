package com.msb.Iterator.v04;

import com.msb.Iterator.v03.ArrayList_;
import com.msb.Iterator.v03.Collection_;

public class Main {
    public static void main(String[] args) {
        Collection_ list = new com.msb.Iterator.v03.ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());

        ArrayList_ al = (ArrayList_)list;
        for (int i = 0; i < al.size(); i++) {
            //如果用这种遍历方式，就不能实现通用了
        }
    }
}
