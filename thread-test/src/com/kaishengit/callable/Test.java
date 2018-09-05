package com.kaishengit.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author jinjianghao
 * @date 2018/9/4
 */
public class Test {

    public static void main(String[] args) {

        CallableDemo callableDemo = new CallableDemo();
        // 借助FutureTask的支持执行callable
        FutureTask<Integer> result = new FutureTask<>(callableDemo);

        new Thread(result).start();

        try {
            // 接收运算结果
            Integer num = result.get();
            System.out.println(num);
            System.out.println("end -----------");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
