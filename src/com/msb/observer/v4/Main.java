package com.msb.observer.v4;

/**
 * 加入多个观察者
 */

class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        dad.feed();
        dog.wang();
        mum.hug();
    }

}

class Dad {
    public void feed() {
        System.out.println("dad feeding");
    }
}

class Mum {
    public void hug() {
        System.out.println("dad feeding");
    }
}

class Dog {
    public void wang() {
        System.out.println("dad feeding");
    }
}

public class Main {
}
