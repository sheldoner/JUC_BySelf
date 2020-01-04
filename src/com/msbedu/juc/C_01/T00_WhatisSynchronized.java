package com.msbedu.juc.C_01;

/**
 *此示例表示:
 * volatile 只能保证可见性,不能保证原子性
 * synchronized 既能保证原子性,也能保证可见性
 *
 * 程序多运行几次可以显示出差别
 * 2020年1月4日 22:09:34
 */
public class T00_WhatisSynchronized implements Runnable {


    private static /*volatile*/ int count = 100;

    public /*synchronized*/ void run(){
        count--;
        /*try{
            Thread.sleep(1000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
        System.out.println(Thread.currentThread().getName() + " count is:"+count);
    }
    public static void main(String[] args){

        T00_WhatisSynchronized t = new T00_WhatisSynchronized();
        for (int i = 0; i < 10; i++) {
            new Thread(t,"线程"+i).start();
        }
    }
}
