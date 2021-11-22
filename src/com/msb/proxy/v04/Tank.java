package com.msb.proxy.v04;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最贱的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？
 * 用继承？
 * v04:使用代理
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

interface Movable {
    void move();
}
