package com.msbedu.juc.C_00;

public class T00_WhatisThread {

    static class T1 extends Thread{
        @Override
        public void run(){
            try{
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello t1 Thread " +i);
                    sleep(1L);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello t2 Thread " +i);
                    try{
                        Thread.sleep(1000L);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        new T1().start();
        t2.start();
        System.out.println(t2.getState());
        t2.interrupt();
    }
}
