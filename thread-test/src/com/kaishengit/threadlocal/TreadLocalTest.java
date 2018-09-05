package com.kaishengit.threadlocal;

import java.util.Random;

public class TreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " put data :" + data);
                    threadLocal.set(data);

                    try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                    int res = threadLocal.get();
                    System.out.println(Thread.currentThread().getName() + " get data :" + res);
                }
            }).start();
        }
    }
    
}
