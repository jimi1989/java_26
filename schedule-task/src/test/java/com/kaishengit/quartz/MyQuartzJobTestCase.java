package com.kaishengit.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

/**
 * @author jinjianghao
 * @date 2018/8/16
 */
public class MyQuartzJobTestCase {

    @Test
    public void testRun() throws SchedulerException, IOException {

        // 创建jobDetail指定执行的任务
        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class).build();

        // 定义trigger何时触发任务
        SimpleScheduleBuilder ssb = SimpleScheduleBuilder.simpleSchedule();
        // 设置间隔时间为5秒
        ssb.withIntervalInSeconds(1);
        // 永不间断
        ssb.repeatForever();

        Trigger simpleTrigger = TriggerBuilder.newTrigger().withSchedule(ssb).build();

        // 通过schedule调度任务
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();

        System.in.read();

    }

    @Test
    public void cronTest() throws SchedulerException, IOException {
        // 创建jobDetail指定执行的任务
        JobDetail jobDetail = JobBuilder.newJob(MyQuartzJob.class).build();

        // 根据cron表达式来确定任务触发的时间点
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ? *");
        Trigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();

        // 通过schedule调度任务
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();

        System.in.read();
    }

}
