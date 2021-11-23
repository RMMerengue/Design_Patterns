package com.msb.Iterator.v04;

public class ArrayList_ implements Collection_ {
    Object[] objects = new Object[10];
    private int index = 0;

    @Override
    public void add(Object o) {
        if(index==objects.length){
            Object[] newObject = new Object[objects.length*2];
            System.arraycopy(objects, 0, newObject, 0, objects.length);
            objects = newObject;
        }
        objects[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }
}
