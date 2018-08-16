package com.kaishengit.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author jinjianghao
 * @date 2018/8/16
 */
public class MyQuartzJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("this is a quartz job...");

    }
}
