package com.kaishengit.mq;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * @author jinjianghao
 * @date 2018/8/7
 */
public class ConsumerListener4 implements SessionAwareMessageListener {

    public void onMessage(Message message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("====>" + textMessage.getText());
//            if(textMessage.getText().startsWith("spring,mq")) {
//                throw new JMSException("出异常了");
//            }

            // textMessage.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
            session.recover();
        }
    }
}
