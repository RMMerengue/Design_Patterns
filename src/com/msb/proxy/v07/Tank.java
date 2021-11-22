package com.msb.proxy.v07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
 * v07:如果有stop方法需要代理
 * 如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型Object
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
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
        Tank tank = new Tank();

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class}, //tank.class.getInterFaces()
                new LogHander(tank)
        );
        m.move();
    }
}

class LogHander implements InvocationHandler {
    Tank tank;
    public LogHander(Tank tank){
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method" + method.getName() + "start");
        Object o = method.invoke(tank, args);
        System.out.println("method" + method.getName() + "end");
        return o;
    }
}

interface Movable {
    void move();
}
