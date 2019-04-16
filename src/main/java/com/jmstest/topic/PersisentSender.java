package com.jmstest.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PersisentSender {
	/**
	 * 持久化订阅发送者
	 * @param args
	 */
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		Session session=null;
		Connection connection=null;
		try {
			connection = connectionFactory.createConnection();

			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createTopic("myTopic");

			MessageProducer producer = session.createProducer(destination);

			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			//必须设置了投递模式后，启动connection才有效
			connection.start();

			for (int i=0;i<3;i++){
				TextMessage textMessage = session.createTextMessage("发送消息222" + i);
				System.out.println(textMessage.getText());
				producer.send(textMessage);

			}
			session.commit();

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}