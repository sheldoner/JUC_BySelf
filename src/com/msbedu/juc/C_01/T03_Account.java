package com.msbedu.juc.C_01;

import java.util.concurrent.TimeUnit;

/**
 * 面试题：模拟银行账户
 * 对业务写方法加锁
 * 对业务读方法不加锁
 * 这样行不行？
 *
 * 容易产生脏读问题（dirtyRead）
 */

public class T03_Account {
    String name;

    double balance;

    public synchronized void set(String name, double balance){
        this.name = name;
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return this.balance;
    }

    public static void main(String[] args){
        T03_Account t = new T03_Account();

        new Thread(()->t.set("zhangsan",200.0)).start();

        System.out.println(t.getBalance());
        try {
            Thread.sleep(2000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(t.getBalance());
    }
}
