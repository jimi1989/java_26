package com.kaishengit.erp.quartz;

import com.kaishengit.erp.service.impl.FixOrderServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
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

        //1. 获取Spring容器对象
       /* ApplicationContext applicationContext = (ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContext");
        FixOrderServiceImpl fixOrderService = applicationContext.getBean(FixOrderServiceImpl.class);

        fixOrderService.*/


    }
}
