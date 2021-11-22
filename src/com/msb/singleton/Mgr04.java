package com.msb.singleton;

/**
 * lazy loading
 * 可以通过synchronized解决，但是效率下降
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {};

    public static synchronized Mgr04 getInstance() {
        if(INSTANCE == null) {
            try{
                Thread.sleep(5);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public  void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
