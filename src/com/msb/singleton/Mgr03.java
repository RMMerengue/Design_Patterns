package com.msb.singleton;

/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但是线程不安全
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {};

    public static Mgr03 getInstance() {
        if(INSTANCE == null) {
            try{
                Thread.sleep(5);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public  void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }

}
