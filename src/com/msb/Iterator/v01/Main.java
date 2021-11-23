package com.msb.Iterator.v01;

import java.util.Objects;

/**
 * 构建一个容器，可以添加对象
 */
public class Main {
    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}

class ArrayList_ {
    Object[] objects = new Object[10];
    //objects下一个空的位置在哪，或者说，目前容器中有多少个元素
    private int index = 0;
    public void add(Object o){
        if(index == objects.length) {
            Object[] newObjects = new Object[objects.length*2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
    }
    public int size() {
        return index;
    }
}
