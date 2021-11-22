package com.msb.strategy;

public class Cat implements com.msb.strategy.Comparable<Cat> {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat o) {
        Cat c = o;
        if(this.weight < c.weight) return -1;
        else if (this.weight > c.weight) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
