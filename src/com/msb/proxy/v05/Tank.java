package com.msb.proxy.v05;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最贱的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？
 * 用继承？
 * v04:使用代理
 * v05:代理有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator？
 */
public class Tank implements Movable{
    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
       System.out.println("Tank moving");
        try{
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
        new TankLogProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable{
    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class TankLogProxy implements Movable{
    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("start moving");
        tank.move();
        System.out.println("stop moving");
    }
}

interface Movable {
    void move();
}
