package com.kaishengit.automicDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jinjianghao
 * @date 2018/9/4
 */
public class AutomicDemo implements Runnable{

    private AtomicInteger num = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(num.getAndIncrement());
    }
}
