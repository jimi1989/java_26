package com.kaishengit.springTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Date;

/**
 * @author jinjianghao
 * @date 2018/8/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-task.xml")
public class SpringTaskTestCase {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Test
    public void testRun() throws IOException {
        // 立即执行
        // taskScheduler.execute(new SpringTask());

        // 指定时间执行
        // taskScheduler.schedule(new SpringTask(), new Date(System.currentTimeMillis() + 3000L));

        // 从上一次任务结束之后开始延迟3000ms
        // taskScheduler.scheduleWithFixedDelay(new SpringTask(), 100L);

        // 从上一次任务开始之后延迟1000ms
        // taskScheduler.scheduleAtFixedRate(new SpringTask(), 4000L);

        // 使用trigger cron表达式
        // taskScheduler.schedule(new SpringTask(), new CronTrigger("0/5 * * * * ?"));
        System.in.read();
    }

}
