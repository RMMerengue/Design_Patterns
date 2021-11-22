package com.msb.factoryMethod;

/**
 * 简单工厂的可扩展性不好
 */
public class SimpleVehicleFactory {
    public com.msb.factoryMethod.Car createCar(){
        return new Car();
    }

    public com.msb.factoryMethod.Plane creatrePlane() {
        return new Plane();
    }
}
