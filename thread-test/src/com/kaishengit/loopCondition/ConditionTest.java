package com.kaishengit.loopCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jinjianghao
 * @date 2018/9/4
 *
 *  编写一个程序，开启三个线程，这三个线程的id分别为A，B，C，要求输出ABCABCABC..,10次
 */
public class ConditionTest {

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    conditionDemo.loopA();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    conditionDemo.loopB();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    conditionDemo.loopC();
                }
            }
        }, "C").start();


    }

}


class ConditionDemo {

    /*
     * 当前正在执行的线程标记
     */
    private int number = 1;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public void loopA() {
        lock.lock();

        try{
            if(number != 1) {
                condition1.await();
            }

            // number == 1 打印A
            System.out.print(Thread.currentThread().getName());

            // 唤醒
            number = 2;
            condition2.signal();

        } catch (Exception e) {
            System.out.println("exception ...");
        } finally {
            lock.unlock();
        }
    }

    public void loopB() {
        lock.lock();

        try{
            if(number != 2) {
                condition2.await();
            }

            // number == 2 打印A
            System.out.print(Thread.currentThread().getName());

            // 唤醒
            number = 3;
            condition3.signal();

        } catch (Exception e) {
            System.out.println("exception ...");
        } finally {
            lock.unlock();
        }
    }

    public void loopC() {
        lock.lock();

        try{
            if(number != 3) {
                condition3.await();
            }

            // number == 3 打印A
            System.out.print(Thread.currentThread().getName());

            // 唤醒
            number = 1;
            condition1.signal();

        } catch (Exception e) {
            System.out.println("exception ...");
        } finally {
            lock.unlock();
        }
    }

}