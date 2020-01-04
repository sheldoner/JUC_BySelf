package com.msbedu.juc.C_00;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程的创建方式
 * 1.继承Thread
 * 2.实现Runable
 * 3.实现Callable
 * 4.Executors.newCachedThreadPool()
 * 5.Lambda表达式
 */

public class T01_HowToCreateThread {
    private static class T1 extends Thread {
        @Override
        public void run() {
            try{
                Thread.sleep(100L);
                System.out.println("hello my Thread!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static class T2 implements Runnable{
        @Override
        public void run() {
            System.out.println("hello my Runnnable");
        }
    }

    private static class T3 implements Callable{
        @Override
        public Object call() throws Exception {
           System.out.println("hell my Callable");
           return null;
        }
    }

    public static void main(String[] args){
        new T1().start();
        new Thread(new T2()).start();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.submit(new T3());
        new Thread(()->{
            System.out.println("hello my Lambda!");
        }).start();
    }
}
