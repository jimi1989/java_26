package com.kaishengit.springTask.annotation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author jinjianghao
 * @date 2018/8/16
 */
@Component
public class MyTaskJob {

    // @Scheduled(fixedDelay = 1000)
    public void fixedJob() {
        System.out.println("this is a fixed job");
    }

    @Scheduled(fixedRate = 1000)
    @Async
    public void rateJob() {
        System.out.println(Thread.currentThread().getName() + "begin......");
        try {
            System.out.println("this is a rate job");
            Thread.sleep(2000);
            if(1 == 1) {
                throw new RuntimeException("出异常了...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end.............");
    }

}
