package com.jmstest.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueSender {
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
		Session session=null;
		Connection connection=null;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("my-queue");

			MessageProducer producer = session.createProducer(destination);

			for (int i=0;i<3;i++){
				TextMessage textMessage = session.createTextMessage("发送消息" + i);
				producer.send(destination,textMessage);

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