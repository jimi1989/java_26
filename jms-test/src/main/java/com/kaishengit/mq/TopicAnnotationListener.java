package com.kaishengit.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author jinjianghao
 * @date 2018/8/8
 */
@Component
public class TopicAnnotationListener {

    @JmsListener(destination = "spring-topic")
    public void getTopicMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("接受的信息：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = "spring-queue", containerFactory = "jmsQueueListenerContainerFactory")
    public void getQueueMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("接受的信息：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
