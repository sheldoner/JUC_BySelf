package com.msbedu.juc.C_01;

public class T01_Synchronized {

    public synchronized void m1(){
        System.out.println("hell m1 start!");

        try{
            Thread.sleep(10000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("hell m1 end!");
    }

    public synchronized void m2(){
//        try{
//            Thread.sleep(500L);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        System.out.println("hell m2!");
    }

    public static void main(String[] args){
        T01_Synchronized t = new T01_Synchronized();
        new Thread(()->t.m1(), "t1").start();
        new Thread(()->t.m2(), "t2").start();
        //等同于下面2个写法
//        new Thread(t::m1).start();
//        new Thread(t::m2).start();
    }
}
