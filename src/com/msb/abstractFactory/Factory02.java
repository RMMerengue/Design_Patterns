package com.msb.abstractFactory;

public class Factory02 extends AbstractFactory{
    @Override
    Food createFood() {
        return new FastFood();
    }

    @Override
    Vehicle createVehicle() {
        return new Train();
    }

    @Override
    Weapon createWeapon() {
        return new M16();
    }
}