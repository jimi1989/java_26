package com.kaishengit.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author jinjianghao
 * @date 2018/9/5
 */
public class UseTimeTest {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            new Thread(threadDemo).start();
        }

        try {
            threadDemo.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println((end - start) + "ms");

    }


}

class ThreadDemo implements Runnable{
    CountDownLatch countDownLatch = new CountDownLatch(10);


    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + " down");
    }
}