package com.kaishengit.threadpool;

import java.util.concurrent.*;

/**
 * @author jinjianghao
 * @date 2018/9/4
 */
public class Test {

    public static void main(String[] args) {

		 //设置核心池大小
        int corePoolSize = 5;

        //设置线程池最大能接受多少线程
        int maximumPoolSize = 8;

        //当前线程数大于corePoolSize、小于maximumPoolSize时，超出corePoolSize的线程数的生命周期
        long keepActiveTime = 20;

        //设置时间单位，秒
        TimeUnit timeUnit = TimeUnit.SECONDS;

        //设置线程池缓存队列的排队策略为FIFO，并且指定缓存队列大小为5
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);

        //创建ThreadPoolExecutor线程池对象，并初始化该对象的各种参数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
        		maximumPoolSize,
        		keepActiveTime,
        		timeUnit,
        		workQueue,
                Executors.defaultThreadFactory() ,
                new ThreadPoolExecutor.DiscardPolicy()
        		);

        //往线程池中循环提交线程
        for (int i = 0; i < 15; i++) {
            //创建线程类对象
            MyTask myTask = new MyTask(i);
            //开启线程
            executor.execute(myTask);
            //获取线程池中线程的相应参数
            System.out.println("线程池中线程数目：" +executor.getPoolSize() + "，队列中等待执行的任务数目："+executor.getQueue().size() + "，已执行完的任务数目："+executor.getCompletedTaskCount());
        }
        //待线程池以及缓存队列中所有的线程任务完成后关闭线程池。
        executor.shutdown();

    }

}
