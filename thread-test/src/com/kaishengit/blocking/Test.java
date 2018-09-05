package com.kaishengit.blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {

        final BlockingQueue<Apple> queue = new LinkedBlockingDeque<>(100);

        // 生产者
        new Thread(new Runnable() {

            int appleId = 0;

            @Override
            public void run() {
                try {
                    while (true) {
                        TimeUnit.SECONDS.sleep(1);
                        Apple apple = new Apple(appleId++);
                        System.out.println("生產者生產" + apple.getId());
                        queue.offer(apple);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 消费者
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("消費者消費" + queue.take().getId());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        /*// 生产者
        new Thread(new Runnable() {
            
            int appleId = 0;
            Producer producer = new Producer(queue);
            
            @Override
            public void run() {
                try {
                    while (true) {
                        TimeUnit.SECONDS.sleep(1);
                        producer.put(new Apple(appleId++)); 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 消费者
        new Thread(new Runnable() {
            Consumer consumer = new Consumer(queue);
            
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("消費者消費" + consumer.take().getId());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
	}
	
}
