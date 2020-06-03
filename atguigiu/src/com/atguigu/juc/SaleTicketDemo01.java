package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yu
 * @date 2020/6/1 8:29
 */
public class SaleTicketDemo01 {
    // 主线程 一切程序的入口
    public static void main(String[] args) {
        Tickets ticket = new Tickets();

//        Thread thread1 = new Thread();
//        Thread thread2 = new Thread();
//        Thread thread3 = new Thread();

        // 匿名内部类实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 40; i++) {
                    ticket.sale();
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 40; i++) {
                    ticket.sale();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 40; i++) {
                    ticket.sale();
                }
            }
        }, "C").start();

    }
}

/**
 * 资源类=实例变量+实现方法
 */
class Tickets{
    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try{
            if (number > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第: "+(number--)+"\t还剩下: "+number);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
