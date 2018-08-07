import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.junit.Test;

import javax.jms.*;

/**
 * @author jinjianghao
 * @date 2018/8/7
 */
public class QueueTest {

    @Test
    public void messageProducer() throws Exception {
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        //1. 创建连接工厂
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            //2. 创建连接 并 开启
            connection = connectionFactory.createConnection();
            connection.start();

            //3. 创建Session(param1:是否开启手动提交事务；接收者签收的模式：AUTO_ACKNOWLEDGE（自动签收）;CLIENT_ACKNOWLEDGE(手动签收))
            session = connection.createSession(true,Session.CLIENT_ACKNOWLEDGE);

            //4. 创建消息目的地
            Destination destination = session.createQueue("helloworld-Queue");

            //5. 创建生产者
            producer =  session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            //6. 发送消息
            TextMessage textMessage = session.createTextMessage("Hello,mq-103");
            producer.send(textMessage);

            session.commit();
        }catch (JMSException e) {

            session.rollback();
        } finally {
            //7. 释放资源
            producer.close();
            session.close();
            connection.close();
        }



    }


    @Test
    public void consumerMessage() throws Exception {
        //1. 创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        //设置重试次数
        redeliveryPolicy.setMaximumRedeliveries(3);
        //设置初次重试延迟时间，单位毫秒
        redeliveryPolicy.setInitialRedeliveryDelay(5000);
        //设置每次重试延迟时间，单位毫秒
        redeliveryPolicy.setRedeliveryDelay(5000);

        connectionFactory.setRedeliveryPolicy(redeliveryPolicy);

        //2. 创建并启动连接
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //3. 创建Session
        final Session session = connection.createSession(false,Session.CLIENT_ACKNOWLEDGE);

        //4. 创建目的地对象
        Destination destination = session.createQueue("helloworld-Queue");

        //5. 创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        //6. 处理消息
        consumer.setMessageListener(new MessageListener(){
            public void onMessage(Message message) {
                try {
                    // 消费者获得消息
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(textMessage.getText());
                    if("Hello,mq-103".equals(textMessage.getText())){
                        throw new JMSException("error");
                    }
                    // 手动签收消息
                    textMessage.acknowledge();
                } catch (JMSException e) {
                    e.printStackTrace();
                    // 重新接受消息
                    try {
                        session.recover();
                    } catch (JMSException e1) {
                        e1.printStackTrace();
                    }
                    ;
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
