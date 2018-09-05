package com.kaishengit.automicDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jinjianghao
 * @date 2018/9/5
 */
public class IPlusTest {

    public static void main(String[] args) {
//        int i = 10;
//        i = i++;
//        System.out.println(i);
        PlusDemo pd = new PlusDemo();

        for (int i = 0; i < 100; i++) {
            new Thread(pd).start();
        }

    }

}
class PlusDemo implements Runnable{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.getAndIncrement());
    }
}