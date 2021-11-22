package com.msb.proxy.v06;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最贱的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？
 * 用继承？
 * v04:使用代理
 * v05:代理有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator？
 * v06:代理的对象改成movable类型-越来越像decorator
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
      new TankTimeProxy(
              new TankLogProxy(
                      new Tank()
              )
      ).move();
    }
}

class TankTimeProxy implements Movable{
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class TankLogProxy implements Movable{
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving");
        m.move();
        System.out.println("stop moving");
    }
}

interface Movable {
    void move();
}
