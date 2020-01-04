package com.msbedu.juc.C_01;

public class T02_SynchronizedThis {

    public void m1(){
        synchronized (this){
            System.out.println("hell m1 start!");
            try{
                Thread.sleep(1000L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("hell m1 end!");
        }
    }

    public void m2(){
//        try{
//            Thread.sleep(500L);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        System.out.println("hell m2!");
    }

    public static void main(String[] args){
        T02_SynchronizedThis t = new T02_SynchronizedThis();
        new Thread(()->t.m1(), "t1").start();
        new Thread(()->t.m2(), "t2").start();
        //等同于下面2个写法
//        new Thread(t::m1).start();
//        new Thread(t::m2).start();
    }
}
