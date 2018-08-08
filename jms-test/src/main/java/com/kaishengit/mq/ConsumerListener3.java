package com.kaishengit.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author jinjianghao
 * @date 2018/8/7
 */
@Component
public class ConsumerListener3 {

    @JmsListener(destination = "spring-queue")
    public void getMessage(String message) {
        System.out.println("接受消息：" + message);
    }


}
