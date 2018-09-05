package com.kaishengit.callable;

import java.util.concurrent.Callable;

/**
 * @author jinjianghao
 * @date 2018/9/4
 */
public class CallableDemo implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        int num = 0;
        for(int i = 0; i <= 100; i++) {
            num = num + i;
        }

        return num;
    }
}
