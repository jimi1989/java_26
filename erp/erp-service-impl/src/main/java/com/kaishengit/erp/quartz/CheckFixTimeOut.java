package com.kaishengit.erp.quartz;

import com.kaishengit.erp.service.FixOrderService;
import com.kaishengit.erp.service.impl.FixOrderServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author jinjianghao
 * @date 2018/8/16
 */
public class CheckFixTimeOut implements Job {

    private Logger logger = LoggerFactory.getLogger(CheckFixTimeOut.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        String jobName = jobExecutionContext.getJobDetail().getKey().getName();

        //1. 获取Spring容器对象
        ApplicationContext applicationContext = null;
        try {
            applicationContext = (ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContext");
            FixOrderService fixOrderService = applicationContext.getBean(FixOrderService.class);

            fixOrderService.addFixOrderTimeout(jobName);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }
}
