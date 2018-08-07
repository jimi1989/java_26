package com.kaishengit.mq.spring;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;

/**
 * @author jinjianghao
 * @date 2018/8/7
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jms-spring-topic.xml")
public class SpringTopicTest {

    @Autowired
    JmsTemplate jmsTemplate;

    @Test
    public void testSendMessage() {

        // destinationName方法只能向队列中添加消息
        // Destination destination = new ActiveMQTopic("spring-topic");
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("spring,topic-3");
            }
        });

    }

    @Test
    public void readMessage() throws IOException {
        System.out.println("spring start...");
        System.in.read();
    }

}
