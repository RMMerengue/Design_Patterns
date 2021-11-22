package com.msb.strategy;

public class Dog implements Comparable<Dog> {
    public int foodAmount;

    public Dog(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    @Override
    public int compareTo(Dog o) {
        Dog d = o;
        if(this.foodAmount<d.foodAmount) return -1;
        else if(this.foodAmount>d.foodAmount) return 1;
        return 0;
    }
}
