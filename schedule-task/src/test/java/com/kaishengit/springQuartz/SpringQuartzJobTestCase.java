package com.kaishengit.springQuartz;

import com.kaishengit.quartz.MyQuartzJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Random;

/**
 * @author jinjianghao
 * @date 2018/8/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-quartz.xml")
public class SpringQuartzJobTestCase {

    private int taskId = 1004;

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

//    @Autowired
//    private JobDetail jobDetail;
//    @Autowired
//    private Trigger trigger;

    @Test
    public void testRun() throws IOException {
        System.out.println("容器启动成功...");
        System.in.read();
    }

    @Test
    public void addTaskTest() {
        // schedulerFactoryBean.setOverwriteExistingJobs(true);

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("message", "come for dinner?");

            JobDetail jobDetail = JobBuilder.newJob(SendWeixinJob.class)
                    .withIdentity("task:" + taskId, "weixin")
                    .setJobData(jobDataMap)
                    .build();

            String cronExpression = "0/10 * 22 16 8 ? 2018";
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            Trigger trigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void delJob() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.deleteJob(new JobKey("jobDetail", "default"));
    }


}
