import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

/**
 * @author jinjianghao
 * @date 2018/8/7
 */
public class TopicTest {

    @Test
    public void createTopic() throws JMSException {

        //1. 创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //2. 创建连接 并 开启
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //3. 创建Session
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        // 4.创建Topic对象(目的地对象)
        Destination destination = session.createTopic("helloTopic");

        //5. 创建生产者
        MessageProducer producer = session.createProducer(destination);

        //6.发送消息
        TextMessage textMessage = session.createTextMessage("Hello,Topic-MQ2");
        producer.send(textMessage);

        //7. 释放资源
        producer.close();
        session.close();
        connection.close();

    }

    @Test
    public void consumerTopic() throws JMSException, IOException {
        //1. 创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //2. 创建连接 并 开启
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //3. 创建Session
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        // 4.创建Topic对象(目的地对象)
        Destination destination = session.createTopic("helloTopic");

        // 5.创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        // 6.设置监听
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        System.in.read();
        //7. 释放资源
        consumer.close();
        session.close();
        connection.close();
    }

}
