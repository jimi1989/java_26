package com.kaishengit.erp.mq;

import com.kaishengit.erp.service.FixOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * @author jinjianghao
 * @date 2018/8/8
 */
public class FixOrderListener implements SessionAwareMessageListener {

    private Logger logger = LoggerFactory.getLogger(FixOrderListener.class);

    @Autowired
    private FixOrderService fixOrderService;

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        TextMessage textMessage = (TextMessage) message;

        try {
            // 获得队列中的json数据
            String json = textMessage.getText();
            logger.info("接收的队列json数据:{}", json);
            fixOrderService.createFixOrder(json);

            textMessage.acknowledge();
        } catch (JMSException e) {
            e.printStackTrace();
            session.recover();
        }
    }
}

