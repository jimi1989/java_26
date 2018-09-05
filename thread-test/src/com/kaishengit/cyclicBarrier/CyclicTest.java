package com.kaishengit.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jinjianghao
 * @date 2018/9/5
 */
public class CyclicTest {

    public static void main(String[] args) {
        Task task = new Task();
        try {
            new Thread(task).start();
            Thread.sleep(1000);
            new Thread(task).start();
            Thread.sleep(1000);
            new Thread(task).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Task implements Runnable {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "已经到达" + System.currentTimeMillis());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("线程" + Thread.currentThread().getName() + "开始处理" + System.currentTimeMillis());
    }
}
