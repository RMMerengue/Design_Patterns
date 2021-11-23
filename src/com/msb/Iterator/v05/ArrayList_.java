package com.msb.Iterator.v05;

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

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_ {
        private int currenIndex = 0;

        @Override
        public boolean hasNext() {
            if(currenIndex >= index) return false;
            return true;
        }

        @Override
        public Object next() {
            Object o = objects[currenIndex];
            currenIndex++;
            return o;
        }
    }
}
