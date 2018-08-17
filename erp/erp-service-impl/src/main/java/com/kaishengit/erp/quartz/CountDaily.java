package com.kaishengit.erp.quartz;

import com.kaishengit.erp.entity.FixOrder;
import com.kaishengit.erp.entity.Order;
import com.kaishengit.erp.service.OrderService;
import com.kaishengit.erp.service.impl.FixOrderServiceImpl;
import com.kaishengit.erp.service.impl.OrderServiceImpl;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/16
 */
public class CountDaily implements Job {

    private Logger logger = LoggerFactory.getLogger(CountDaily.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //1. 获取Spring容器对象
        ApplicationContext applicationContext = null;
        try {
            applicationContext = (ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContext");
            OrderService orderService = applicationContext.getBean(OrderService.class);
            orderService.countDailyOrder();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }


    }
}
